package com.example.dong.yomoo.activities.farmer.services.tab1;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.entitiy.LivestockDemand;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * 牲畜需求详情页
 */
public class LivestockDemandDetailActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = LivestockDemandDetailActivity.class.getSimpleName();
    private TextView tvTitle, tvContent, tvPublisherDate;
    private SwipeRefreshLayout swipeRefreshLayout;

    private long demandId;
    private LivestockDemand livestockDemand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livestock_demand_detail_activity);

        if (getIntent().getExtras() == null) {
            return;
        }
        Bundle bundle = getIntent().getExtras();
        demandId = bundle.getLong("demand_id", -1);
        if (demandId == -1) {
            return;
        }

        initToolbar();

        tvTitle = findViewById(R.id.tv_title);
        tvPublisherDate = findViewById(R.id.tv_publisher_and_date);
        tvContent = findViewById(R.id.tv_content);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);

        getLivestockDetail();
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
        getLivestockDetail();
    }

    private void getLivestockDetail() {
        Map<String, Object> params = new HashMap<>();

        RequestBean requestBean = new RequestBean(TAG, HttpAPI.GET_LIVESTOCK_DEMAND_DETAIL + demandId, params);
        httpHandler.getLivestockDemandDetail(requestBean, new HttpCallback<LivestockDemand>() {
            @Override
            public void onSuccess(BaseResult<LivestockDemand> result) {
                livestockDemand = result.getData();
                tvTitle.setText(livestockDemand.getTitle());
                tvPublisherDate.setText(String.format("%s %s", livestockDemand.getPublisher().getName(), livestockDemand.getCreatedAt()));
                tvContent.setText(livestockDemand.getContent());
            }

            @Override
            public void onFailure(String errMsg) {
                showToast(errMsg);
                L.d(errMsg);
            }
        });

    }
}
