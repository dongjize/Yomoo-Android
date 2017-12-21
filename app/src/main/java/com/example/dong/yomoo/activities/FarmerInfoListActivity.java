package com.example.dong.yomoo.activities;

import android.os.Bundle;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.users.Farmer;

import java.util.List;

/**
 * 养殖户信息列表页
 * <p>
 * Created by dong on 17/12/2017.
 */

public class FarmerInfoListActivity extends BaseActivity {

    private List<Farmer> farmerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_info_list_activity);
    }

    @Override
    protected void initToolbar() {

    }
}
