package com.example.dong.yomoo.http.handlers;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.http.VolleyUtils;
import com.example.dong.yomoo.http.handlers.BaseHttpHandler;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dong on 20/12/2017.
 */

public class HttpHandler extends BaseHttpHandler {

    public HttpHandler(Context context) {
        super(context);
    }

    /**
     * 用户注册
     *
     * @param requestBean
     * @param callback
     */
    public void userRegister(RequestBean requestBean, final HttpCallback callback) {
        volleyUtils.httpPostString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        BaseResult result = new BaseResult();
                        result.setValue("");
                        result.setData(null);
                        result.setMessage(jsonObject.getString("message"));
                        result.setResultCode(jsonObject.getInt("code"));
                        callback.onSuccess(result);
                    } else {
                        callback.onFailure(jsonObject.getString("message"));
                    }
                } catch (JSONException e) {
                    callback.onFailure(e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
    }

    /**
     * 用户登录
     *
     * @param requestBean
     * @param callback
     */
    public void userLogin(RequestBean requestBean, final HttpCallback callback) {
        volleyUtils.httpPostString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("result_code") == HttpAPI.RESULT_OK) {
                        BaseResult result = new BaseResult();
                        result.setValue("");
                        result.setData(null);
                        result.setMessage(jsonObject.getString("message"));
                        result.setResultCode(jsonObject.getInt("result_code"));
                        callback.onSuccess(result);
                    } else {
                        callback.onFailure(jsonObject.getString("message"));
                    }
                } catch (JSONException e) {
                    callback.onFailure(e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
    }

}
