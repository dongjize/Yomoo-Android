package com.example.dong.yomoo.activities.vendor;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseHomeActivity;
import com.example.dong.yomoo.activities.SplashActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dong on 17/12/2017.
 */

public class VendorHomeActivity extends BaseHomeActivity {
    private static final String TAG = VendorHomeActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private List<VendorHomeModel> modelList;
    private VendorHomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_home_activity);

        initToolbar();

        recyclerView = findViewById(R.id.recycler_view);

        modelList = new ArrayList<>();
        VendorHomeModel[] models = {
                new VendorHomeModel("我的订单", "", HistoryOrderListActivity.class),
                new VendorHomeModel("我的库存", "", FodderStockListActivity.class),
                new VendorHomeModel("历史进货", "", PurchaseListActivity.class),
                new VendorHomeModel("添加进货信息", "", PurchaseInputActivity.class),
                new VendorHomeModel("发布养殖技术", "", BreedingInfoPublishActivity.class)
        };
        modelList.addAll(Arrays.asList(models));

        adapter = new VendorHomeAdapter(context, modelList);
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
