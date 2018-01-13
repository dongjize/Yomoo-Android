package com.example.dong.yomoo.activities.common;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.FarmerListActivity;
import com.example.dong.yomoo.activities.farmer.FarmerHomeActivity;
import com.example.dong.yomoo.activities.vendor.VendorHomeActivity;
import com.example.dong.yomoo.entitiy.users.Farmer;
import com.example.dong.yomoo.entitiy.users.User;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.Global;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册后完善信息页面
 */
public class CompleteInfoActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = CompleteInfoActivity.class.getSimpleName();
    private EditText etName, etVillage, etGroup, etStreet, etLivestock, etExpLivestock, etIntro;
    private LinearLayout farmerInfoLayout;
    private Button submitBtn;
    private boolean isFarmer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_info_activity);

        initToolbar();

        etName = findViewById(R.id.et_name);
        etIntro = findViewById(R.id.et_intro);
        submitBtn = findViewById(R.id.btn_submit);
        submitBtn.setOnClickListener(this);
        farmerInfoLayout = findViewById(R.id.farmer_info_layout);

        if (Global.user == null || Global.user.getType() == null) {
            return;
        }

        isFarmer = Global.user.getType().equals(User.FARMER);

        if (isFarmer) {
            farmerInfoLayout.setVisibility(View.VISIBLE);
            etVillage = findViewById(R.id.et_village);
            etGroup = findViewById(R.id.et_group);
            etStreet = findViewById(R.id.et_street_num);
            etLivestock = findViewById(R.id.et_livestock);
            etExpLivestock = findViewById(R.id.et_exp_livestock);
            etIntro = findViewById(R.id.et_intro);
        } else {
            farmerInfoLayout.setVisibility(View.GONE);
        }

    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                completeInfo();
                break;
        }
    }

    private void completeInfo() {
        String name = etName.getText().toString();
        if (TextUtils.isEmpty(name)) {
            showToast("姓名不能为空");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("id", Global.user.getId() + "");
        params.put("name", name);
        params.put("intro", etIntro.getText().toString());
        if (isFarmer) {
            params.put("village", etVillage.getText().toString());
            params.put("group", etGroup.getText().toString());
            params.put("street_num", etStreet.getText().toString());
            params.put("livestock", etLivestock.getText().toString());
            params.put("exp_livestock", etExpLivestock.getText().toString());
        }
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.COMPLETE_INFO, params);

        httpHandler.userCompleteInfo(requestBean, new HttpCallback<User>() {
            @Override
            public void onSuccess(BaseResult result) {
                showToast("资料完善成功！");
                Global.user = (User) result.getData();
                if (isFarmer) {
                    Global.farmer = (Farmer) result.getData();
                }
                Intent intent = new Intent();
                switch (Global.user.getType()) {
                    case User.FARMER:
                        intent.setClass(context, FarmerHomeActivity.class);
                        break;
                    case User.VENDOR:
                        intent.setClass(context, VendorHomeActivity.class);
                        break;
                    case User.BUTCHER:
                        intent.setClass(context, FarmerListActivity.class);
                        break;
                    case User.SUPPORTER:
                        intent.setClass(context, FarmerListActivity.class);
                        break;
                }
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(String errMsg) {
                showToast(errMsg);
            }
        });

    }

}
