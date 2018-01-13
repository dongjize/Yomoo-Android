package com.example.dong.yomoo.activities.vendor;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.entitiy.Purchase;
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
 * 饲料销售商:
 * 进货列表页
 */
public class PurchaseListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = PurchaseListActivity.class.getSimpleName();
    private ListView listView;
    private List<Purchase> purchaseList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private PurchaseListAdapter mAdapter;
    private String offset = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_list_activity);

        listView = findViewById(R.id.list_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        purchaseList = new ArrayList<>();

        requestPurchaseList();
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
        requestPurchaseList();
    }

    private void requestPurchaseList() {
        Map<String, Object> params = new HashMap<>();
        params.put("vendor_id", Global.user.getId() + "");
        params.put("offset", TextUtils.isEmpty(offset) ? "0" : offset);
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.FODDER_Of_VENDOR_LIST, params);
        httpHandler.getPurchaseList(requestBean, new HttpCallback<List<Purchase>>() {
            @Override
            public void onSuccess(BaseResult<List<Purchase>> result) {
                purchaseList = result.getData();
                if (mAdapter == null) {
                    mAdapter = new PurchaseListAdapter(context, purchaseList);
                    listView.setAdapter(mAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //TODO
//                            Purchase purchase = purchaseList.get(position);
//                            Intent intent = new Intent(context, PurchaseDetailActivity.class);
//                            Bundle bundle = new Bundle();
//
//                            intent.putExtras(bundle);
//                            startActivity(intent);
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
