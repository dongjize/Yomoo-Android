package com.example.dong.yomoo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.users.Farmer;
import com.example.dong.yomoo.entities.users.User;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.CommonUtils;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户注册页面
 * 注册时需提交的字段：手机号，密码，用户类型
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = RegisterActivity.class.getSimpleName();
    private EditText etPhone, etPassword;
    private Spinner spinner;
    private Button registerBtn;

    private String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        userType = User.FARMER;
        initToolbar();

        registerBtn = findViewById(R.id.btn_register);
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
        registerBtn.setOnClickListener(this);
        spinner = findViewById(R.id.user_type_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] userTypes = getResources().getStringArray(R.array.user_types);
                Map<String, String> typeMap = new HashMap<>();
                typeMap.put(userTypes[0], User.FARMER);
                typeMap.put(userTypes[1], User.VENDOR);
                typeMap.put(userTypes[2], User.BUTCHER);
                typeMap.put(userTypes[3], User.SUPPORTER);
                userType = typeMap.get(userTypes[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void register() {
        String phone = etPhone.getText().toString();
        String password = etPassword.getText().toString();

        if (!CommonUtils.checkMobileNumber(phone)) {
            showToast("手机号格式有误");
            return;
        }

        if (password.length() < 6 || password.length() > 20) {
            showToast("密码长度应在6到20位之间");
            return;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        params.put("password", password);
        params.put("type", userType);
        RequestBean requestBean = new RequestBean(TAG, HttpAPI.REGISTER, params);
        httpHandler.userRegister(requestBean, new HttpCallback<User>() {
            @Override
            public void onSuccess(BaseResult result) {
                showToast("注册成功！");
                Global.user = (User) result.getData();
                Global.isLogin = true;
                if (userType.equals(User.FARMER)) {
                    Global.farmer = (Farmer) Global.user;
                }
                Intent intent = new Intent(context, CompleteInfoActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(String errMsg) {
                showToast(errMsg);
                L.d(errMsg);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                register();
                break;
        }
    }
}
