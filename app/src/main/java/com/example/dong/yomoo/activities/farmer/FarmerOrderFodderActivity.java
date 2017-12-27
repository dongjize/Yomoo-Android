package com.example.dong.yomoo.activities.farmer;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;

/**
 * Created by dong on 22/12/2017.
 */

public class FarmerOrderFodderActivity extends BaseActivity {
    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}
