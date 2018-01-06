package com.example.dong.yomoo.activities.vendor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.activities.farmer.services.tab2.FarmerOrderFodderActivity;
import com.example.dong.yomoo.entities.FodderOfVendor;
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
 * （饲料销售商）饲料库存列表
 */
public class FodderStockListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = FodderStockListAdapter.class.getSimpleName();
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<FodderOfVendor> fvList;
    private FodderStockListAdapter mAdapter;
    private String offset = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fodder_stock_list_activity);

        initToolbar();

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);

        listView = findViewById(R.id.list_view);
        fvList = new ArrayList<>();

        requestFodderStockList();

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
        requestFodderStockList();
    }

    private void requestFodderStockList() {
        Map<String, Object> params = new HashMap<>();
        params.put("vendor_id", Global.user.getId() + "");
        params.put("offset", TextUtils.isEmpty(offset) ? "0" : offset);
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.FODDER_Of_VENDOR_LIST, params);
        httpHandler.getFodderOfVendorListByVendor(requestBean, new HttpCallback<List<FodderOfVendor>>() {
            @Override
            public void onSuccess(BaseResult<List<FodderOfVendor>> result) {
                fvList = result.getData();
                if (mAdapter == null) {
                    mAdapter = new FodderStockListAdapter(context, fvList);
                    listView.setAdapter(mAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            FodderOfVendor fv = fvList.get(position);
                            Intent intent = new Intent(context, FarmerOrderFodderActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putLong("fv_id", fv.getId());
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
