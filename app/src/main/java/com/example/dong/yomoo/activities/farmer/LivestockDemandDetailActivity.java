package com.example.dong.yomoo.activities.farmer;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;

/**
 * 牲畜需求详情页
 */
public class LivestockDemandDetailActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private TextView tvTitle, tvContent, tvPublisherDate;
    private SwipeRefreshLayout swipeRefreshLayout;

    private long demandId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livestock_demand_detail_activity);

        if (getIntent().getExtras() == null) {
            return;
        }
        Bundle bundle = getIntent().getExtras();
        demandId = bundle.getLong("demand_id", -1);
        if (demandId == -1) {
            return;
        }

        initToolbar();

        tvTitle = findViewById(R.id.tv_title);
        tvContent = findViewById(R.id.tv_content);
        tvPublisherDate = findViewById(R.id.tv_publish_date);
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

    private void getLivestockDetail() {
        // TODO
    }
}
