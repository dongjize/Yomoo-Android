package com.example.dong.yomoo.activities.vendor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
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
 * 饲料销售商：
 * 历史订单列表页
 */
public class HistoryOrderListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = HistoryOrderListActivity.class.getSimpleName();
    private ListView orderListView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private HistoryOrderListAdapter mAdapter;
    private List<Order> orderList;
    private String offset = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_order_list_activity);

        orderListView = findViewById(R.id.list_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        orderList = new ArrayList<>();

        getHistoryOrderList();
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
        getHistoryOrderList();
    }

    private void getHistoryOrderList() {
        Map<String, Object> params = new HashMap<>();
        long id = Global.user.getId();
        params.put("offset", offset);

        RequestBean requestBean = new RequestBean(TAG, HttpAPI.VENDOR_INFO + id + "/" + HttpAPI.VENDOR_GET_HISTORY_ORDER_LIST, params);
        httpHandler.getHistoryOrderList(requestBean, new HttpCallback<List<Order>>() {
            @Override
            public void onSuccess(BaseResult<List<Order>> result) {
                swipeRefreshLayout.setRefreshing(false);
                orderList = result.getData();
                if (mAdapter == null) {
                    mAdapter = new HistoryOrderListAdapter(context, orderList);
                    orderListView.setAdapter(mAdapter);
                    orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(context, OrderEntryDetailActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putLong("order_id", orderList.get(position).getId());
                            intent.putExtras(bundle);
                            context.startActivity(intent);
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
}
