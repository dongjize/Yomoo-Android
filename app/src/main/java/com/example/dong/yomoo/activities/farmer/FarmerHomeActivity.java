package com.example.dong.yomoo.activities.farmer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.activities.LoginActivity;
import com.example.dong.yomoo.activities.farmer.profile.FarmerProfileFragment;
import com.example.dong.yomoo.activities.farmer.services.FarmerServiceFragment;
import com.example.dong.yomoo.application.MyApplication;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.utils.L;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 养殖户主页有2个tab：
 * tab1："我的"页面 FarmerProfileFragment
 * tab2："服务"页面 FarmerServiceFragment
 */
public class FarmerHomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = FarmerHomeActivity.class.getSimpleName();
    private MyApplication application;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> fragments;
    private Fragment profileFragment, servicesFragment;
    private FarmerHomeTabAdapter mAdapter;

    private MenuItem logoutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_home_activity);
        application = MyApplication.getInstance();

        initToolbar();

        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tablayout);

        //设置TabLayout
        fragments = new ArrayList<>();
        profileFragment = new FarmerProfileFragment();
        servicesFragment = new FarmerServiceFragment();
        fragments.add(profileFragment);
        fragments.add(servicesFragment);
        List<String> titles = new ArrayList<>();
        titles.add("我的");
        titles.add("服务");

        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));
        mAdapter = new FarmerHomeTabAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_farmer_home, menu);
        toolbar.getMenu().findItem(R.id.action_logout);
        logoutBtn = toolbar.getMenu().findItem(R.id.action_logout);
        return true;
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

    private void logout() {
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
