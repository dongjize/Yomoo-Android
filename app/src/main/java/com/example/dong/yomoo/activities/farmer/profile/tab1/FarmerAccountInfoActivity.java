package com.example.dong.yomoo.activities.farmer.profile.tab1;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.entitiy.Order;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.utils.L;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dong on 22/12/2017.
 */
public class FarmerAccountInfoActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = FarmerAccountInfoActivity.class.getSimpleName();
    private List<Order> orderList;
    private ListView orderListView;
    private FarmerAccountInfoAdapter mAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String offset = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_account_info_activity);

        initToolbar();

        orderList = new ArrayList<>();
        orderListView = findViewById(R.id.list_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);

        requestFarmerAccountInfo();

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
        requestFarmerAccountInfo();
    }

    private void requestFarmerAccountInfo() {
        Map<String, Object> params = new HashMap<>();
        long id = Global.user.getId();
        params.put("offset", offset);

        RequestBean requestBean = new RequestBean(TAG, HttpAPI.FARMER_INFO + id + "/" + HttpAPI.FARMER_GET_HISTORY_ORDER_LIST, params);
        httpHandler.getHistoryOrderList(requestBean, new HttpCallback<List<Order>>() {
            @Override
            public void onSuccess(BaseResult<List<Order>> result) {
                swipeRefreshLayout.setRefreshing(false);
                orderList = result.getData();
                if (mAdapter == null) {
                    mAdapter = new FarmerAccountInfoAdapter(context, orderList);
                    orderListView.setAdapter(mAdapter);
                } else {
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(String errMsg) {
                swipeRefreshLayout.setRefreshing(false);
                showToast(errMsg);
                L.d(errMsg);
            }
        });
    }
}
