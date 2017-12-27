package com.example.dong.yomoo.activities.vendor;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;

/**
 * Created by dong on 16/12/2017.
 */
public class HistoryOrderListActivity extends BaseActivity {

    private RecyclerView orderListView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_order_list_activity);

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
