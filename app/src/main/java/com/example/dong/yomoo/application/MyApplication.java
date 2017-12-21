package com.example.dong.yomoo.application;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;

import com.example.dong.yomoo.http.RequestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dong on 16/12/2017.
 */

public class MyApplication extends Application {
    private static MyApplication app = null;
    private List<Activity> activityList;
    protected ProgressDialog progressDialog;

    public static MyApplication getInstance() {
        if (null == app) {
            synchronized (MyApplication.class) {
                app = new MyApplication();
            }
        }
        return app;
    }

//    private MyApplication() {
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        activityList = new ArrayList<>();
        RequestUtils.initRequest(getApplicationContext());

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void finishAllActivities() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }

    public void exitApplication() {
        finishAllActivities();
    }

    protected void setProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("正在加载...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
    }

}
