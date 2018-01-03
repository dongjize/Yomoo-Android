package com.example.dong.yomoo.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.users.Farmer;

import java.util.ArrayList;
import java.util.List;

/**
 * 养殖户信息列表页
 * <p>
 * Created by dong on 17/12/2017.
 */

public class FarmerListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private List<Farmer> farmerList;
    private FarmerListAdapter mAdapter;
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String offset = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_info_list_activity);

        initToolbar();

        farmerList = new ArrayList<>();
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        listView = findViewById(R.id.list_view);

        getFarmerList();
    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public void onRefresh() {
        offset = "0";
    }

    private void getFarmerList() {

    }
}
