package com.example.dong.yomoo.activities.farmer.services.tab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
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
 * 饲料销售商列表
 */
public class VendorListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = VendorListActivity.class.getSimpleName();
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView mListView;
    private VendorListAdapter mAdapter;
    private String offset = "0";
    private List<User> vendorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_list_activity);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        vendorList = new ArrayList<>();
        mListView = findViewById(R.id.list_view);

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
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.USER_LIST, params);
        httpHandler.getUserList(requestBean, new HttpCallback<List<User>>() {

            @Override
            public void onSuccess(BaseResult<List<User>> result) {
                swipeRefreshLayout.setRefreshing(false);
                offset = result.getValue();
                vendorList = result.getData();
                if (vendorList != null) {
                    if (mAdapter == null) {
                        mAdapter = new VendorListAdapter(context, vendorList);
                        mListView.setAdapter(mAdapter);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                final User user = vendorList.get(position);
                                Intent intent = new Intent(context, VendorInfoDetailActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putLong("vendor_id", user.getId());
                                intent.putExtras(bundle);
                                context.startActivity(intent);
                            }
                        });
                    } else {
                        mAdapter.notifyDataSetChanged();
                    }
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
        getVendorList();
    }
}
