package com.example.dong.yomoo.activities.farmer.services.tab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.entities.FodderOfVendor;
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
 * 养殖户账号下的：
 * 饲料销售商详情页面，即所销售的饲料列表页
 */
public class VendorInfoDetailActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = VendorInfoDetailActivity.class.getSimpleName();

//    private RecyclerView recyclerView;

    private VendorInfoDetailAdapter mAdapter;
    private ListView listView;
    private long vendorId = -1;

    private String offset = "0";

    private List<FodderOfVendor> fvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_info_detail_activity);

        if (getIntent().getExtras() == null) {
            return;
        }

        Bundle bundle = getIntent().getExtras();
        if (bundle.getLong("vendor_id") == -1) {
            return;
        }

        vendorId = bundle.getLong("vendor_id");

        initToolbar();

//        recyclerView = findViewById(R.id.recycler_view);
        listView = findViewById(R.id.list_view);
        fvList = new ArrayList<>();

        getVendorInfoDetail();

    }


    private void getVendorInfoDetail() {
        Map<String, Object> params = new HashMap<>();
        params.put("vendor_id", vendorId + "");
        params.put("offset", TextUtils.isEmpty(offset) ? "0" : offset);
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.FODDER_Of_VENDOR_LIST, params);
        httpHandler.getFodderOfVendorListByVendor(requestBean, new HttpCallback<List<FodderOfVendor>>() {
            @Override
            public void onSuccess(BaseResult<List<FodderOfVendor>> result) {
                fvList = result.getData();
                if (mAdapter == null) {
                    mAdapter = new VendorInfoDetailAdapter(context, fvList);
                    listView.setAdapter(mAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            FodderOfVendor fv = fvList.get(position);
                            Intent intent = new Intent(context, FarmerOrderFodderActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putLong("id", fv.getId());
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
        getVendorInfoDetail();
    }
}
