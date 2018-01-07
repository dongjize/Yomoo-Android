package com.example.dong.yomoo.activities.farmer.services.tab3;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.entities.BreedingInfo;
import com.example.dong.yomoo.entities.LivestockDemand;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * 养殖户：
 * 养殖技术信息详情
 */
public class BreedingInfoDetailActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = BreedingInfoDetailActivity.class.getSimpleName();
    private TextView tvTitle, tvContent, tvPublishDate;
    private SwipeRefreshLayout swipeRefreshLayout;

    private BreedingInfo breedingInfo;
    private long infoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breeding_info_detail_activity);

        if (getIntent().getExtras() == null) {
            return;
        }
        Bundle bundle = getIntent().getExtras();
        infoId = bundle.getLong("info_id", -1);
        if (infoId == -1) {
            return;
        }

        initToolbar();

        tvTitle = findViewById(R.id.tv_title);
        tvContent = findViewById(R.id.tv_content);
        tvPublishDate = findViewById(R.id.tv_publish_date);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);

        getBreedingInfoDetail();
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
    public void onRefresh() {
        getBreedingInfoDetail();
    }

    private void getBreedingInfoDetail() {
        Map<String, Object> params = new HashMap<>();
        params.put("info_id", infoId);

        RequestBean requestBean = new RequestBean(TAG, HttpAPI.FARMER_GET_BREEDING_INFO_LIST, params);
        httpHandler.getBreedingInfoDetail(requestBean, new HttpCallback<BreedingInfo>() {
            @Override
            public void onSuccess(BaseResult<BreedingInfo> result) {
                breedingInfo = result.getData();
                tvTitle.setText(breedingInfo.getTitle());
                tvPublishDate.setText(String.format("%s %s", breedingInfo.getPublisher().getName(), breedingInfo.getCreatedAt()));
                tvContent.setText(breedingInfo.getContent());
            }

            @Override
            public void onFailure(String errMsg) {
                showToast(errMsg);
                L.d(errMsg);
            }
        });
    }
}
