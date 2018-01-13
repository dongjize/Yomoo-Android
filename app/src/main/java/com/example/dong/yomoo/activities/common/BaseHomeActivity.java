package com.example.dong.yomoo.activities.common;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.application.MyApplication;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dong on 01/01/2018.
 */

public abstract class BaseHomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = BaseHomeActivity.class.getSimpleName();
    private MyApplication application;

    protected MenuItem logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = MyApplication.getInstance();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_farmer_home, menu);
        toolbar.getMenu().findItem(R.id.action_logout);
        logoutBtn = toolbar.getMenu().findItem(R.id.action_logout);
        return true;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (!Global.isExit) {
            Global.isExit = true;
            showToast("再按一次退出程序");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Global.isExit = false;
                }
            }, 2000);
        } else {
            application.exitApplication();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                new AlertDialog.Builder(context).setTitle("确认退出登录？").setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        logout();
                    }
                });
                break;
            default:
                break;
        }
        return false;
    }

    protected void logout() {
        Map<String, Object> params = new HashMap<>();
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.LOGOUT + Global.user.getId(), params);
        httpHandler.userLogout(requestBean, new HttpCallback() {
            @Override
            public void onSuccess(BaseResult result) {
                Global.farmer = null;
                Global.user = null;
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(String errMsg) {
                showToast(errMsg);
                L.d(errMsg);
            }
        });
    }
}
