package com.example.dong.yomoo.activities.farmer.services.tab2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.entities.FodderOfVendor;
import com.example.dong.yomoo.entities.Order;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * 养殖户下订单
 */
public class FarmerOrderFodderActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = FarmerOrderFodderActivity.class.getSimpleName();
    private Button orderBtn;
    private Spinner spinner;
    private TextView tvFodderName, tvSellPrice, tvFodderStock, tvAddress;
    private EditText etQuantity;
    private FodderOfVendor fv;
    private long fvId = -1;

    private int fodderStock = -1;
    private String orderType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_order_fodder_activity);

        if (getIntent().getExtras() == null) {
            finish();
            return;
        }
        Bundle bundle = getIntent().getExtras();
        if (bundle.getLong("fv_id", -1) == -1) {
            finish();
            return;
        }
        fvId = bundle.getLong("fv_id");

        etQuantity = findViewById(R.id.et_order_quantity);
        orderBtn = findViewById(R.id.btn_order);
        orderBtn.setEnabled(false);
        spinner = findViewById(R.id.order_type_spinner);
        tvFodderName = findViewById(R.id.tv_fodder_name);
        tvSellPrice = findViewById(R.id.tv_sell_price);
        tvFodderStock = findViewById(R.id.tv_fodder_stock);
        tvAddress = findViewById(R.id.tv_farmer_address);

        tvAddress.setText(Global.farmer.getAddress());

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] orderTypes = getResources().getStringArray(R.array.order_types);
                Map<String, String> typeMap = new HashMap<>();
                typeMap.put(orderTypes[0], Order.PAYED_ORDER);
                typeMap.put(orderTypes[1], Order.OWED_ORDER);
                orderType = typeMap.get(orderTypes[position]);
            }
        });

        getFodderDetail();

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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_order:
                postOrder();
                break;
        }
    }

    private void getFodderDetail() {
        Map<String, Object> params = new HashMap<>();
        params.put("fv_id", fvId);
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.GET_FODDER_DETAIL + fvId, params);
        httpHandler.getFodderDetail(requestBean, new HttpCallback<FodderOfVendor>() {
            @Override
            public void onSuccess(BaseResult<FodderOfVendor> result) {
                fv = result.getData();
                tvFodderName.setText(fv.getFodder().getName());
                tvFodderStock.setText(fv.getStock() + "");
                tvSellPrice.setText(fv.getSellPrice() + "");
                orderBtn.setEnabled(true);
                orderBtn.setOnClickListener(FarmerOrderFodderActivity.this);
            }

            @Override
            public void onFailure(String errMsg) {
                showToast(errMsg);
                L.d(errMsg);
            }
        });
    }


    private void postOrder() {
        String quantity = etQuantity.getText().toString();
        if (TextUtils.isEmpty(quantity)) {
            quantity = "1";
        }
        if (Integer.parseInt(quantity) > fodderStock) {
            showToast("库存不足");
            return;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("fv_id", fvId);
        params.put("quantity", quantity);
        params.put("order_type", orderType);
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.FARMER_POST_ORDER, params);
        httpHandler.postOrder(requestBean, new HttpCallback<Order>() {
            @Override
            public void onSuccess(BaseResult<Order> result) {
                showToast(result.getMessage());
                finish();
            }

            @Override
            public void onFailure(String errMsg) {
                showToast(errMsg);
                L.d(errMsg);
            }
        });
    }
}
