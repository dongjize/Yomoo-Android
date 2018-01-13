package com.example.dong.yomoo.activities.vendor;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.entitiy.BreedingInfo;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * （饲料销售商）养殖技术发布页面
 */
public class BreedingInfoPublishActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = BreedingInfoPublishActivity.class.getSimpleName();
    private EditText etTitle, etContent;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breeding_info_publish_activity);

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
                postBreedingInfo();
                break;
        }
    }

    private void postBreedingInfo() {
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
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.POST_BREEDING_INFO, params);
        httpHandler.postBreedingInfo(requestBean, new HttpCallback<BreedingInfo>() {
            @Override
            public void onSuccess(BaseResult<BreedingInfo> result) {
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
