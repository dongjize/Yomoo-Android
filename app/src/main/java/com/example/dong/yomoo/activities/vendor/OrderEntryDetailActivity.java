package com.example.dong.yomoo.activities.vendor;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.entities.OrderEntry;

/**
 * 历史订单详情页面
 */
public class OrderEntryDetailActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private OrderEntry orderEntry;
    private long entryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_entry_detail_activity);

        if (getIntent().getExtras() == null) {
            return;
        }
        Bundle bundle = getIntent().getExtras();
        entryId = bundle.getLong("entry_id", -1);
        if (entryId == -1) {
            return;
        }

        initToolbar();

        getOrderEntryDetail();

    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void getOrderEntryDetail() {
        // TODO
    }

    @Override
    public void onRefresh() {
        getOrderEntryDetail();
    }
}
