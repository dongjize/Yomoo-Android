package com.example.dong.yomoo.http;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by dong on 20/12/2017.
 */

public class RequestUtils {
    protected static final String TAG = RequestUtils.class.getSimpleName();
    private static RequestQueue mRequestQueue;

    public static void initRequest(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public void addToRequestQueue(Request<?> request, String tag) {
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);

        getRequestQueue().add(request);

    }

    public void addToRequestQueue(Request<?> request) {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
