package com.example.dong.yomoo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dong.yomoo.R;

/**
 * Created by dong on 16/12/2017.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText etPhone, etPassword;
    private Button loginBtn;
    private TextView tvRegisterNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        loginBtn = findViewById(R.id.btn_login);
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
        tvRegisterNow = findViewById(R.id.tv_register_now);

        loginBtn.setOnClickListener(this);
        tvRegisterNow.setOnClickListener(this);
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_register_now:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                // TODO bundle
                startActivity(intent);
                break;
            case R.id.btn_login:
                //TODO request server

                break;
        }
    }
}
