package com.example.dong.yomoo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.activities.common.FarmerInfoDetailActivity;
import com.example.dong.yomoo.entitiy.users.Farmer;
import com.example.dong.yomoo.entitiy.users.User;
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
        params.put("type", User.FARMER);
        params.put("offset", TextUtils.isEmpty(offset) ? "0" : offset);
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.USER_LIST, params);
        httpHandler.getFarmerList(requestBean, new HttpCallback<List<Farmer>>() {
            @Override
            public void onSuccess(BaseResult<List<Farmer>> result) {
                swipeRefreshLayout.setRefreshing(false);
                farmerList = result.getData();
                if (mAdapter == null) {
                    mAdapter = new FarmerListAdapter(context, farmerList);
                    listView.setAdapter(mAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Farmer farmer = farmerList.get(position);
                            Intent intent = new Intent(context, FarmerInfoDetailActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putLong("farmer_id", farmer.getId());
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
                swipeRefreshLayout.setRefreshing(false);
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
