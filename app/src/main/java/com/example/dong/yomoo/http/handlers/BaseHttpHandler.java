package com.example.dong.yomoo.http.handlers;

import android.content.Context;

import com.example.dong.yomoo.http.VolleyUtils;

/**
 * Created by dong on 16/12/2017.
 */

public class BaseHttpHandler {
    protected static final String TAG = BaseHttpHandler.class.getSimpleName();
    protected Context context;

    protected VolleyUtils volleyUtils;

    public BaseHttpHandler(Context context) {
        this.context = context;
        volleyUtils = new VolleyUtils();
    }
}
