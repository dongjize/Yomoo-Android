package com.example.dong.yomoo.activities.farmer.services.tab3;

import android.os.Bundle;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.entities.BreedingInfo;

/**
 * 养殖户：
 * 养殖技术信息详情
 */
public class BreedingInfoDetailActivity extends BaseActivity {

    private BreedingInfo breedingInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breeding_info_detail_activity);

        //TODO get ID

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
