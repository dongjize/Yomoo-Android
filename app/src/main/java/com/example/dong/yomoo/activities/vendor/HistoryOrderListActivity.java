package com.example.dong.yomoo.activities.vendor;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
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

    private SearchView searchView;
    private MenuItem searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_order_list_activity);

        initToolbar();

        orderListView = findViewById(R.id.list_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        orderList = new ArrayList<>();

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = new SearchView(getSupportActionBar().getThemedContext());
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setIconifiedByDefault(true);
        searchView.setMaxWidth(1000);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        searchItem = menu.add(android.R.string.search_go);
        searchItem.setIcon(R.mipmap.ic_search_white_36dp);
        searchItem.setActionView(searchView);
        searchItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS
                | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        showSearch(false);
        Bundle bundle = intent.getExtras();
//        String userQuery = String.valueOf(bundle.get(SearchManager.USER_QUERY));
        String query = String.valueOf(bundle.get(SearchManager.QUERY));
//        poiSearch.searchInCity((new PoiCitySearchOption()).city(GlobalData.CITY).keyword(query).pageNum(0));
        // TODO 网络请求query
        getHistoryOrderListByKeyword(query);
    }

    private void showSearch(boolean visible) {
        if (visible) {
            searchItem.expandActionView();
        } else {
            searchItem.collapseActionView();
            hideKeyboard(searchView.getWindowToken());
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
        params.put("vendor_id", id + "");
        params.put("offset", offset + "");

        RequestBean requestBean = new RequestBean(TAG, HttpAPI.VENDOR_GET_HISTORY_ORDER_LIST, params);
        httpHandler.getHistoryOrderList(requestBean, new HttpCallback<List<Order>>() {
            @Override
            public void onSuccess(BaseResult<List<Order>> result) {
                swipeRefreshLayout.setRefreshing(false);
                orderList.clear();
                orderList.addAll(result.getData());
                if (mAdapter == null) {
                    mAdapter = new HistoryOrderListAdapter(context, orderList);
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


    private void getHistoryOrderListByKeyword(String keyword) {
        Map<String, Object> params = new HashMap<>();
        long id = Global.user.getId();
        params.put("vendor_id", id + "");
        params.put("offset", offset + "");
        params.put("key", keyword);

        RequestBean requestBean = new RequestBean(TAG, HttpAPI.QUERY_VENDOR_ORDER_LIST, params);
        httpHandler.getHistoryOrderListByKeyword(requestBean, new HttpCallback<List<Order>>() {
            @Override
            public void onSuccess(BaseResult<List<Order>> result) {
                swipeRefreshLayout.setRefreshing(false);
                orderList.clear();
                orderList.addAll(result.getData());
                if (mAdapter == null) {
                    mAdapter = new HistoryOrderListAdapter(context, orderList);
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
