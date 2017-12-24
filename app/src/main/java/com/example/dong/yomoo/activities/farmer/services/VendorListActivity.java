package com.example.dong.yomoo.activities.farmer.services;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;

import java.util.HashMap;

/**
 * 饲料销售商列表
 */
public class VendorListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private VendorListAdapter mAdapter;
    private String nextStart = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_list_activity);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView = findViewById(R.id.recycler_view);

    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void getVendorList() {
        swipeRefreshLayout.setRefreshing(false);
        HashMap<String, Object> params = new HashMap<>();
        params.put("next_start", TextUtils.isEmpty(nextStart) ? "0" : nextStart);
    }

    @Override
    public void onRefresh() {

    }
}
