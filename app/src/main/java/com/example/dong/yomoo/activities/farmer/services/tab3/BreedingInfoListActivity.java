package com.example.dong.yomoo.activities.farmer.services.tab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.entitiy.BreedingInfo;
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
 * 饲料销售商发布的养殖技术列表
 */

public class BreedingInfoListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = BreedingInfoListActivity.class.getSimpleName();
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<BreedingInfo> breedingInfoList;
    private BreedingInfoListAdapter mAdapter;
    private String offset = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breeding_info_list_activity);

        initToolbar();

        listView = findViewById(R.id.list_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        breedingInfoList = new ArrayList<>();

        requestBreedingInfoList();

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
        requestBreedingInfoList();
    }

    private void requestBreedingInfoList() {
        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);

        RequestBean requestBean = new RequestBean(TAG, HttpAPI.FARMER_GET_BREEDING_INFO_LIST, params);
        httpHandler.getBreedingInfoList(requestBean, new HttpCallback<List<BreedingInfo>>() {
            @Override
            public void onSuccess(BaseResult<List<BreedingInfo>> result) {
                breedingInfoList = result.getData();
                if (mAdapter == null) {
                    mAdapter = new BreedingInfoListAdapter(context, breedingInfoList);
                    listView.setAdapter(mAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(context, BreedingInfoDetailActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putLong("info_id", breedingInfoList.get(position).getId());
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
                showToast(errMsg);
                L.d(errMsg);
            }
        });
    }
}
