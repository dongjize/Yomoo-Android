package com.example.dong.yomoo.activities.farmer.services.tab3;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;

/**
 * 饲料销售商发布的养殖技术列表
 */

public class BreedingInfoListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breeding_info_list_activity);

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
