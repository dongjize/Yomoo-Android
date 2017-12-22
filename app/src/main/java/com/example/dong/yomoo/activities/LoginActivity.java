package com.example.dong.yomoo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.butcher.ButcherHomeActivity;
import com.example.dong.yomoo.activities.farmer.FarmerHomeActivity;
import com.example.dong.yomoo.activities.supporter.SupporterHomeActivity;
import com.example.dong.yomoo.activities.vendor.VendorHomeActivity;
import com.example.dong.yomoo.entities.users.User;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.Global;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dong on 16/12/2017.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText etPhone, etPassword;
    private Button loginBtn;
    private TextView tvRegisterNow;

    private String from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle.getString("from") != null) {
                from = bundle.getString("from");
            }
        }

        initToolbar();

        loginBtn = findViewById(R.id.btn_login);
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
        tvRegisterNow = findViewById(R.id.tv_register_now);

        loginBtn.setOnClickListener(this);
        tvRegisterNow.setOnClickListener(this);
    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (from.equals(SplashActivity.class.getSimpleName())) {
            return;
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_register_now:
                Intent toRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(toRegister);
                break;
            case R.id.btn_login:
                String phone = etPhone.getText().toString();
                String password = etPassword.getText().toString();
                Map<String, Object> params = new HashMap<>();
                params.put("phone", phone);
                params.put("password", password);
                RequestBean requestBean = new RequestBean(TAG, params, HttpAPI.LOGIN);
                httpHandler.userLogin(requestBean, new HttpCallback() {
                    @Override
                    public void onSuccess(BaseResult result) {
                        Intent toHome = new Intent();
                        User user = (User) result.getData();
                        Global.user = user;
                        switch (user.getType()) {
                            case User.FARMER:
                                toHome.setClass(context, FarmerHomeActivity.class);
                                break;
                            case User.VENDOR:
                                toHome.setClass(context, VendorHomeActivity.class);
                                break;
                            case User.BUTCHER:
                                toHome.setClass(context, ButcherHomeActivity.class);
                                break;
                            case User.SUPPORTER:
                                toHome.setClass(context, SupporterHomeActivity.class);
                                break;
                            default:
                                break;
                        }
                        startActivity(toHome);
                    }

                    @Override
                    public void onFailure(String errMsg) {
                        showToast(errMsg);
                    }
                });
                break;
        }
    }
}
