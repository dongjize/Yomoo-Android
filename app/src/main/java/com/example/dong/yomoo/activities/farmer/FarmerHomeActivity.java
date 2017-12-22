package com.example.dong.yomoo.activities.farmer;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.activities.farmer.adapter.FarmerHomeTabAdapter;
import com.example.dong.yomoo.activities.farmer.fragments.profile.FarmerProfileFragment;
import com.example.dong.yomoo.activities.farmer.fragments.ServicesForFarmerFragment;
import com.example.dong.yomoo.application.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * 养殖户主页有2个tab：
 * tab1：“我”页面 FarmerProfileFragment
 * tab2：ServicesForFarmerFragment
 * 牲畜需求信息列表页 LivestockDemandListFragment
 * 饲料销售商列表页 VendorListFragment
 * 养殖方法列表页 BreedingInfoListActivity
 * <p>
 * Created by dong on 17/12/2017.
 */

public class FarmerHomeActivity extends BaseActivity {
    private MyApplication application;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> fragments;
    private Fragment profileFragment, servicesFragment;
    private FarmerHomeTabAdapter mAdapter;


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
        servicesFragment = new ServicesForFarmerFragment();
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
}
