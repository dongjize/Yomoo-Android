package com.example.dong.yomoo.activities.farmer.services.tab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.entitiy.LivestockDemand;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.L;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 肉品加工商发布的牲畜需求列表
 */
public class LivestockDemandListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = LivestockDemandListActivity.class.getSimpleName();
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private List<LivestockDemand> livestockDemandList;
    private LiveStockDemandAdapter mAdapter;
    private String offset = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livestock_demand_list_activity);

        initToolbar();

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        listView = findViewById(R.id.list_view);
        livestockDemandList = new ArrayList<>();

        requestLivestockDemandList();
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
        offset = "0";
        requestLivestockDemandList();
    }

    private void requestLivestockDemandList() {
        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);

        RequestBean requestBean = new RequestBean(TAG, HttpAPI.GET_LIVESTOCK_DEMAND_LIST, params);
        httpHandler.getLivestockDemandList(requestBean, new HttpCallback<List<LivestockDemand>>() {
            @Override
            public void onSuccess(BaseResult<List<LivestockDemand>> result) {
                livestockDemandList = result.getData();
                if (mAdapter == null) {
                    mAdapter = new LiveStockDemandAdapter(context, livestockDemandList);
                    listView.setAdapter(mAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(context, LivestockDemandDetailActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putLong("demand_id", livestockDemandList.get(position).getId());
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
                } else {
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(String errMsg) {
                showToast(errMsg);
                L.d(errMsg);
            }
        });
    }
}
