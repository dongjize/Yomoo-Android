package com.example.dong.yomoo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dong.yomoo.R;

/**
 * Created by dong on 16/12/2017.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView registerTv;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        loginBtn = findViewById(R.id.btn_login);
        registerTv = findViewById(R.id.tv_register_now);

        loginBtn.setOnClickListener(this);
        registerTv.setOnClickListener(this);

    }

    @Override
    protected void initToolbar() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_register_now:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                //TODO request server

                break;
        }
    }
}
