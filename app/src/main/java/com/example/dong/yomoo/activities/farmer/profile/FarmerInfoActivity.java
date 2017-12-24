package com.example.dong.yomoo.activities.farmer.profile;

import android.os.Bundle;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.entities.users.Farmer;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * 养殖户个人信息页面
 */
public class FarmerInfoActivity extends BaseActivity {

    private static final String TAG = FarmerInfoActivity.class.getSimpleName();
    private TextView tvName, tvVillage, tvGroup, tvStreet, tvLivestock, tvExpLivestock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_info_activity);

        initToolbar();

        tvName = findViewById(R.id.tv_name);
        tvVillage = findViewById(R.id.tv_village);
        tvGroup = findViewById(R.id.tv_group);
        tvStreet = findViewById(R.id.tv_street_num);
        tvLivestock = findViewById(R.id.tv_livestock);
        tvExpLivestock = findViewById(R.id.tv_exp_livestock);

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
        long farmerId = Global.farmer.getFarmerId();
        params.put("farmer_id", farmerId + "");

        RequestBean requestBean = new RequestBean(TAG, params, HttpAPI.FARMER_INFO + farmerId);
        httpHandler.getFarmerInfo(requestBean, new HttpCallback() {
            @Override
            public void onSuccess(BaseResult result) {
                Farmer farmer = (Farmer) result.getData();
                tvName.setText(farmer.getName());
                tvVillage.setText(farmer.getVillage());
                tvGroup.setText(farmer.getGroup());
                tvStreet.setText(farmer.getStreetNum());
                tvLivestock.setText(farmer.getLivestock());
                tvExpLivestock.setText(farmer.getExpLivestock());
            }

            @Override
            public void onFailure(String errMsg) {
                showToast(errMsg);
                L.d(errMsg);
            }
        });

    }
}
