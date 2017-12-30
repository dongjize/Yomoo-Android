package com.example.dong.yomoo.activities.farmer.profile;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.activities.butcher.LivestockDemandPublishActivity;
import com.example.dong.yomoo.entities.BreedingInfoDemand;
import com.example.dong.yomoo.entities.LivestockDemand;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * 养殖户发布养殖技术需求页面
 */
public class BreedingInfoDemandPublishActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = BreedingInfoDemandPublishActivity.class.getSimpleName();
    private EditText etTitle, etContent;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breeding_info_demand_publish_activity);

        etTitle = findViewById(R.id.et_title);
        etContent = findViewById(R.id.et_content);
        submitBtn = findViewById(R.id.btn_submit);
        submitBtn.setOnClickListener(this);

        initToolbar();

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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                postBreedingInfoDemand();
                break;
        }
    }

    private void postBreedingInfoDemand() {
        String title = etTitle.getText().toString();
        if (TextUtils.isEmpty(title)) {
            showToast("标题不能为空");
            return;
        }
        String content = etContent.getText().toString();
        if (TextUtils.isEmpty(content)) {
            showToast("正文不能为空");
            return;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("content", content);
        params.put("publisher", Global.user.getId() + "");
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.POST_BREEDING_INFO_DEMAND, params);
        httpHandler.postBreedingInfoDemand(requestBean, new HttpCallback<BreedingInfoDemand>() {
            @Override
            public void onSuccess(BaseResult<BreedingInfoDemand> result) {
                showToast(result.getMessage());
                finish();
            }

            @Override
            public void onFailure(String errMsg) {
                showToast(errMsg);
                L.d(errMsg);
            }
        });
    }
}
