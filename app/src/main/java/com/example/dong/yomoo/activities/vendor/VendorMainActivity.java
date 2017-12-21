package com.example.dong.yomoo.activities.vendor;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dong on 17/12/2017.
 */

public class VendorMainActivity extends BaseActivity {
    private static final String TAG = VendorMainActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private List<VendorMainModel> modelList;
    private VendorMainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_main_activity);

        recyclerView = findViewById(R.id.recycler_view);

        modelList = new ArrayList<>();
        VendorMainModel[] models = {
                new VendorMainModel("我的订单", "", OrderListActivity.class),
                new VendorMainModel("我的库存", "", FodderStockListActivity.class),
                new VendorMainModel("添加进货信息", "", PurchaseListActivity.class)
        };
        modelList.addAll(Arrays.asList(models));

        adapter = new VendorMainAdapter(VendorMainActivity.this, modelList);
        RecyclerView.LayoutManager lm = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initToolbar() {

    }

}
