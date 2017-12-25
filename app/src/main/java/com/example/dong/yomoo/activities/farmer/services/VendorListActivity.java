package com.example.dong.yomoo.activities.farmer.services;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.entities.users.User;
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
 * 饲料销售商列表
 */
public class VendorListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = VendorListActivity.class.getSimpleName();
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private VendorListAdapter mAdapter;
    private String offset = "0";
    private List<User> vendorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_list_activity);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView = findViewById(R.id.recycler_view);
        vendorList = new ArrayList<>();

        getVendorList();
    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void getVendorList() {
        swipeRefreshLayout.setRefreshing(false);
        Map<String, Object> params = new HashMap<>();
        params.put("type", User.VENDOR);
        params.put("offset", TextUtils.isEmpty(offset) ? "0" : offset);
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.VENDOR_LIST, params);
        httpHandler.getUserList(requestBean, new HttpCallback<List<User>>() {

            @Override
            public void onSuccess(BaseResult<List<User>> result) {
                offset = result.getValue();
                vendorList = result.getData();
                if (vendorList != null) {
                    if (mAdapter == null) {
                        mAdapter = new VendorListAdapter(context, vendorList);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(mAdapter);
                    } else {
                        mAdapter.notifyDataSetChanged();
                    }
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
        getVendorList();
    }
}
