package com.example.dong.yomoo.activities.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.FarmerListActivity;
import com.example.dong.yomoo.activities.farmer.FarmerHomeActivity;
import com.example.dong.yomoo.entities.users.User;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.activities.vendor.VendorHomeActivity;

/**
 * Created by dong on 16/12/2017.
 */

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private static final int POST_DELAYED = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toTargetActivity();
                finish();
            }
        }, POST_DELAYED);

    }

    private void toTargetActivity() {
        Intent intent = new Intent();
        if (Global.isLogin && Global.user != null) {
            String userType = Global.user.getType();
            switch (userType) {
                case User.FARMER:
                    intent.setClass(SplashActivity.this, FarmerHomeActivity.class);
                    break;
                case User.VENDOR:
                    intent.setClass(SplashActivity.this, VendorHomeActivity.class);
                    break;
                case User.BUTCHER:
                    intent.setClass(SplashActivity.this, FarmerListActivity.class);
                    break;
                case User.SUPPORTER:
                    intent.setClass(SplashActivity.this, FarmerListActivity.class);
                    break;
            }
        } else {
            intent.setClass(SplashActivity.this, LoginActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("from", TAG);
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
