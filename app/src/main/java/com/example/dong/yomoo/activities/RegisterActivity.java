package com.example.dong.yomoo.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.users.User;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dong on 16/12/2017.
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                String phone = etPhone.getText().toString();
                String password = etPassword.getText().toString();
                Map<String, Object> params = new HashMap<>();
                params.put("phone", phone);
                params.put("password", password);
                params.put("type", userType);
                RequestBean requestBean = new RequestBean(TAG, params, HttpAPI.REGISTER);
                httpHandler.userRegister(requestBean, new HttpCallback() {
                    @Override
                    public void onSuccess(BaseResult result) {
                        showToast("注册成功！！！");
                    }

                    @Override
                    public void onFailure(String errMsg) {
                        showToast("注册失败！！！");
                    }
                });
                break;
        }
    }
}
