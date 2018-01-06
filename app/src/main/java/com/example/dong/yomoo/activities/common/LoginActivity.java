package com.example.dong.yomoo.activities.common;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.butcher.ButcherHomeActivity;
import com.example.dong.yomoo.activities.farmer.FarmerHomeActivity;
import com.example.dong.yomoo.activities.supporter.SupporterHomeActivity;
import com.example.dong.yomoo.activities.vendor.VendorHomeActivity;
import com.example.dong.yomoo.entities.users.Farmer;
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
 * 用户登录页面，根据不同身份跳转到不同的主页
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText etPhone, etPassword;
    private Button loginBtn;
    private TextView tvRegisterNow;
    private CheckBox checkBox;
    private boolean rememberMe = false;

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
        checkBox = findViewById(R.id.checkbox_remember_me);

        loginBtn.setOnClickListener(this);
        tvRegisterNow.setOnClickListener(this);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rememberMe = b;
            }
        });
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
                login();
                break;
        }
    }

    private void login() {
        String phone = etPhone.getText().toString();
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            showToast("手机号不能为空");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            showToast("密码不能为空");
            return;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        params.put("password", password);
        params.put("remember_me", rememberMe + "");
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.LOGIN, params);
        httpHandler.userLogin(requestBean, new HttpCallback<User>() {
            @Override
            public void onSuccess(BaseResult<User> result) {
                Intent toHome = new Intent();
                User user = result.getData();
                Global.user = user;
                if (user.getName() == null) {
                    toHome.setClass(context, CompleteInfoActivity.class);
                } else {
                    switch (user.getType()) {
                        case User.FARMER:
                            Global.farmer = (Farmer) Global.user;
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
                }
                startActivity(toHome);
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
