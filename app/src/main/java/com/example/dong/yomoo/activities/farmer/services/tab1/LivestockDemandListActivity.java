package com.example.dong.yomoo.activities.farmer.services.tab1;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;

/**
 * 肉品加工商发布的牲畜需求列表
 */

public class LivestockDemandListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livestock_demand_list_activity);

        recyclerView = findViewById(R.id.recycler_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);

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

    }
}
