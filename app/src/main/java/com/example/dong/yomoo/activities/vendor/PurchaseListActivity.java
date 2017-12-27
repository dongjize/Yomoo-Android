package com.example.dong.yomoo.activities.vendor;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;

/**
 * （饲料销售商）进货列表页
 */
public class PurchaseListActivity extends BaseActivity {
    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}
