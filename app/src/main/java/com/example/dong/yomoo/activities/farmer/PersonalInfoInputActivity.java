package com.example.dong.yomoo.activities.farmer;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;

/**
 * Created by dong on 17/12/2017.
 */

public class PersonalInfoInputActivity extends BaseActivity {
    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}
