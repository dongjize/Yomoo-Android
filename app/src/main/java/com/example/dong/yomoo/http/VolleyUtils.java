package com.example.dong.yomoo.http;

import android.text.TextUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.utils.L;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * Created by dong on 20/12/2017.
 */

public class VolleyUtils {
    private static RequestUtils requestUtils;

    public VolleyUtils() {
        requestUtils = new RequestUtils();
    }

    /**
     * GET 基础请求string
     *
     * @param requestBean
     * @param listener
     * @param errorListener
     */
    public void httpGetString(RequestBean requestBean, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        String url = getParams(requestBean.getUrl(), (HashMap<?, ?>) requestBean.getParams());
        StringRequest request = new StringRequest(url, listener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("Cookie", Global.rawCookies);
                String LC = Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
                String userAgent = Global.OBJECTNO + " " + Global.VERSION + " (" +
                        android.os.Build.MANUFACTURER + " " + android.os.Build.MODEL + "; Android OS " +
                        android.os.Build.VERSION.RELEASE + "; " + LC + "; Scale/" + Global.DENSITY + ")";
                hashMap.put("User-agent", userAgent);
                return hashMap;
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    Map<String, String> responseHeaders = response.headers;
                    if (TextUtils.isEmpty(Global.rawCookies)) {
                        Global.rawCookies = responseHeaders.get("Set-Cookie");
                    }
                    String dataString = new String(response.data, "UTF-8");
                    return Response.success(dataString, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                }
            }
        };
        L.i("HttpHandler", url);
        request.setRetryPolicy(new DefaultRetryPolicy(HttpAPI.TIME_OUT, 1, 1.0f));
        requestUtils.addToRequestQueue(request, requestBean.getTag());
    }

    /**
     * POST 基础请求string
     *
     * @param requestBean
     * @param listener
     * @param errorListener
     */
    public void httpPostString(final RequestBean requestBean, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        StringRequest request = new StringRequest(Request.Method.POST, requestBean.getUrl(), listener, errorListener) {
            @Override
            protected Map<String, String> getParams() {
                //在这里设置需要post的参数
                return (Map<String, String>) requestBean.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap localHashMap = new HashMap();
                localHashMap.put("Cookie", Global.rawCookies);
                String LC = Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
                String userAgent = Global.OBJECTNO + " " + Global.VERSION + " (" +
                        android.os.Build.MANUFACTURER + " " + android.os.Build.MODEL + "; Android OS " +
                        android.os.Build.VERSION.RELEASE + "; " + LC + "; Scale/" + Global.DENSITY + ")";
                localHashMap.put("User-agent", userAgent);
                return localHashMap;
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    Map<String, String> responseHeaders = response.headers;
                    if (TextUtils.isEmpty(Global.rawCookies)) {
                        Global.rawCookies = responseHeaders.get("Set-Cookie");
                    }
                    String dataString = new String(response.data, "UTF-8");
                    return Response.success(dataString, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                }
            }
        };
        L.i("HttpHandler", requestBean.getUrl());
        L.i("HttpHandler", requestBean.getParams() == null ? "" : requestBean.getParams().toString());
        request.setRetryPolicy(new DefaultRetryPolicy(HttpAPI.TIME_OUT, 1, 1.0f));
        requestUtils.addToRequestQueue(request, requestBean.getTag());
    }

    /**
     * 拼接GET请求的参数
     *
     * @param params
     * @return
     */
    private String getParams(String url, HashMap<?, ?> params) {
        if (params == null) {
            return url;
        }
        StringBuffer sb = new StringBuffer();
        if (url.endsWith("/")) {
            sb.append(url.substring(0, url.length() - 1));
        } else {
            sb.append(url);
        }
        sb.append("?");
        Iterator<?> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            sb.append(key + "=" + value + "&");
        }
        if (sb.length() > 1) {
            return sb.substring(0, sb.length() - 1);
        }
        return url;
    }

}
