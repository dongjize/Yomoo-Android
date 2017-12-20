package com.example.dong.yomoo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.farmer.FarmerMainActivity;
import com.example.dong.yomoo.users.User;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.activities.vendor.VendorMainActivity;

/**
 * Created by dong on 16/12/2017.
 */

public class SplashActivity extends AppCompatActivity {
    private static final int GO_HOME = 1;
    private static final int GO_LOGIN = 2;
    private static final int POST_DELAYED = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intent = new Intent();
        if (Global.isLogin) {
            User.UserType userType = Global.user.getType();
            switch (userType) {
                case FARMER:
                    intent.setClass(SplashActivity.this, FarmerMainActivity.class);
                    break;
                case VENDOR:
                    intent.setClass(SplashActivity.this, VendorMainActivity.class);
                    break;
                case BUTCHER:
                    intent.setClass(SplashActivity.this, FarmerInfoListActivity.class);
                    break;
                case SUPPORTER:
                    intent.setClass(SplashActivity.this, FarmerInfoListActivity.class);
                    break;
            }
        } else {
            intent.setClass(SplashActivity.this, LoginActivity.class);
        }
        startActivity(intent);
    }
}
