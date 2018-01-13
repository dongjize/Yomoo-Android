package com.example.dong.yomoo.activities.supporter;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.FarmerListActivity;
import com.example.dong.yomoo.activities.butcher.LivestockDemandPublishActivity;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.activities.common.HomeGridAdapter;
import com.example.dong.yomoo.utils.CommonItemModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dong on 22/12/2017.
 */

public class SupporterHomeActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private List<CommonItemModel> modelList;
    private HomeGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supporter_home_activity);
        initToolbar();

        recyclerView = findViewById(R.id.recycler_view);
        modelList = new ArrayList<>();
        CommonItemModel[] models = {
                new CommonItemModel("养殖户名单", FarmerListActivity.class),
        };
        modelList.addAll(Arrays.asList(models));

        adapter = new HomeGridAdapter(context, modelList);
        RecyclerView.LayoutManager lm = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
