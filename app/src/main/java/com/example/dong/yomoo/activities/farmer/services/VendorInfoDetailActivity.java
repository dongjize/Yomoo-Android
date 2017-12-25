package com.example.dong.yomoo.activities.farmer.services;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;

/**
 * 饲料销售商详情页面，即所销售的饲料列表页
 */
public class VendorInfoDetailActivity extends BaseActivity {

    private RecyclerView recyclerView;

    private long vendorId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_info_detail_activity);

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle.getString("vendor_id") != null) {
                vendorId = bundle.getLong("vendor_id");
            }
        }

        initToolbar();

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
}
