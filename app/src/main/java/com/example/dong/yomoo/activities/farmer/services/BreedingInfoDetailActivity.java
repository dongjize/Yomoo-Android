package com.example.dong.yomoo.activities.farmer.services;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;

/**
 * Created by dong on 25/12/2017.
 */
public class BreedingInfoDetailActivity extends BaseActivity {
    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}
