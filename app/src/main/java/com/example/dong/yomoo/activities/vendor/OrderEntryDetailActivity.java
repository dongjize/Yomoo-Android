package com.example.dong.yomoo.activities.vendor;

import android.os.Bundle;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.entities.OrderEntry;

/**
 * 历史订单详情页面
 */
public class OrderEntryDetailActivity extends BaseActivity {

    private OrderEntry orderEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_entry_detail_activity);


        initToolbar();




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
        
    }
}
