package com.example.dong.yomoo.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
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

    private SearchView searchView;
    private MenuItem searchItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_info_list_activity);

        initToolbar();

        farmerList = new ArrayList<>();
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        listView = findViewById(R.id.list_view);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = new SearchView(getSupportActionBar().getThemedContext());
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setIconifiedByDefault(true);
        searchView.setMaxWidth(1000);

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
        String userQuery = String.valueOf(bundle.get(SearchManager.USER_QUERY));
        String query = String.valueOf(bundle.get(SearchManager.QUERY));
//        poiSearch.searchInCity((new PoiCitySearchOption()).city(GlobalData.CITY).keyword(query).pageNum(0));
        // TODO 网络请求query

    }

    private void showSearch(boolean visible) {
        if (visible) {
            searchItem.expandActionView();
        } else {
            searchItem.collapseActionView();
            hideKeyboard(searchView.getWindowToken());
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
