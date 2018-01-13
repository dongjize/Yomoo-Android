package com.example.dong.yomoo.activities.common;

import android.os.Bundle;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.users.Farmer;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dong on 07/01/2018.
 */

public class FarmerInfoDetailActivity extends BaseActivity {

    private static final String TAG = FarmerInfoDetailActivity.class.getSimpleName();
    private TextView tvName, tvVillage, tvGroup, tvStreet, tvLivestock, tvExpLivestock, tvIntro;
    private long farmerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_info_activity);

        if (getIntent().getExtras() == null) {
            return;
        }

        Bundle bundle = getIntent().getExtras();
        if (bundle.getLong("farmer_id") == -1) {
            return;
        }

        farmerId = bundle.getLong("farmer_id");

        initToolbar();

        tvName = findViewById(R.id.tv_name);
        tvVillage = findViewById(R.id.tv_village);
        tvGroup = findViewById(R.id.tv_group);
        tvStreet = findViewById(R.id.tv_street_num);
        tvLivestock = findViewById(R.id.tv_livestock);
        tvExpLivestock = findViewById(R.id.tv_exp_livestock);
        tvIntro = findViewById(R.id.tv_intro);

        getFarmerInfo();
    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void getFarmerInfo() {
        Map<String, Object> params = new HashMap<>();
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.FARMER_INFO + farmerId, params);
        httpHandler.getFarmerInfo(requestBean, new HttpCallback<Farmer>() {
            @Override
            public void onSuccess(BaseResult result) {
                Farmer farmer = (Farmer) result.getData();
                tvName.setText(farmer.getName());
                tvVillage.setText(farmer.getVillage());
                tvGroup.setText(farmer.getGroup());
                tvStreet.setText(farmer.getStreetNum());
                tvLivestock.setText(farmer.getLivestock());
                tvExpLivestock.setText(farmer.getExpLivestock());
                tvIntro.setText(farmer.getIntro());
            }

            @Override
            public void onFailure(String errMsg) {
                showToast(errMsg);
                L.d(errMsg);
            }
        });

    }
}
