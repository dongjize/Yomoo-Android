package com.example.dong.yomoo.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.widget.ListView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.users.Farmer;
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
 * 养殖户信息列表页
 */
public class FarmerListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = FarmerListActivity.class.getSimpleName();
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Farmer> farmerList;
    private ListView listView;
    private FarmerListAdapter mAdapter;
    private String offset = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_info_list_activity);

        initToolbar();

        farmerList = new ArrayList<>();
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        listView = findViewById(R.id.list_view);

        getFarmerList();
    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void getFarmerList() {
        Map<String, Object> params = new HashMap<>();
        params.put("offset", TextUtils.isEmpty(offset) ? "0" : offset);
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.FARMER_LIST, params);
        httpHandler.getFarmerList(requestBean, new HttpCallback<List<Farmer>>() {
            @Override
            public void onSuccess(BaseResult<List<Farmer>> result) {
                farmerList = result.getData();
                if (mAdapter == null) {
                    mAdapter = new FarmerListAdapter(context, farmerList);
                    listView.setAdapter(mAdapter);
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

    @Override
    public void onRefresh() {
        offset = "0";
        getFarmerList();
    }
}
