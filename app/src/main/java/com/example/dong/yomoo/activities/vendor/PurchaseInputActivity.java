package com.example.dong.yomoo.activities.vendor;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.entities.Order;
import com.example.dong.yomoo.entities.Purchase;
import com.example.dong.yomoo.entities.users.User;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * vendor 录入进货信息页面
 */
public class PurchaseInputActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = PurchaseInputActivity.class.getSimpleName();
    private EditText etFodderName, etQuantity, etPurchasePrice, etSellPrice;
    private Spinner spinner;
    private Button submitBtn;
    private String fodderSpec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_input_activity);

        initToolbar();

        etFodderName = findViewById(R.id.et_fodder_name);
        etQuantity = findViewById(R.id.et_purchase_quantity);
        etPurchasePrice = findViewById(R.id.et_purchase_price);
        etSellPrice = findViewById(R.id.et_sell_price);
        spinner = findViewById(R.id.fodder_spec_spinner);
        final String[] specTypes = getResources().getStringArray(R.array.fodder_spec_types);
        fodderSpec = specTypes[0];
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fodderSpec = specTypes[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        submitBtn = findViewById(R.id.btn_submit);
        submitBtn.setOnClickListener(this);
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
            case R.id.btn_submit:
                postPurchaseEntry();
                break;
        }
    }

    private void postPurchaseEntry() {
        String fodderName = etFodderName.getText().toString();
        if (TextUtils.isEmpty(fodderName)) {
            showToast("饲料名不能为空");
            return;
        }

        String quantity = etQuantity.getText().toString();
        if (TextUtils.isEmpty(quantity)) {
            showToast("进货量不能为空");
            return;
        }

        if (Integer.parseInt(quantity) <= 0) {
            showToast("进货量必须大于0");
            return;
        }

        String purchasePrice = etPurchasePrice.getText().toString();
        if (TextUtils.isEmpty(purchasePrice)) {
            showToast("进价不能为空");
            return;
        }
        if (Float.parseFloat(purchasePrice) <= 0) {
            showToast("进价必须大于0");
            return;
        }

        String sellPrice = etSellPrice.getText().toString();
        if (TextUtils.isEmpty(sellPrice)) {
            showToast("售价不能为空");
            return;
        }
        if (Float.parseFloat(sellPrice) <= 0) {
            showToast("售价必须大于0");
            return;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("vendor_id", Global.user.getId() + "");
        params.put("fodder_name", fodderName);
        params.put("fodder_spec", fodderSpec);
        params.put("quantity", quantity);
        params.put("purchase_price", purchasePrice);
        params.put("sell_price", sellPrice);
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.VENDOR_POST_PURCHASE, params);
        httpHandler.postPurchase(requestBean, new HttpCallback<Purchase>() {
            @Override
            public void onSuccess(BaseResult<Purchase> result) {
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
