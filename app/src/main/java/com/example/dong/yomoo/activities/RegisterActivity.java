package com.example.dong.yomoo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.dong.yomoo.R;

/**
 * Created by dong on 16/12/2017.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText etPhone, etPassword;

    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        registerBtn = findViewById(R.id.btn_register);
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);

        registerBtn.setOnClickListener(this);
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                //TODO 处理网络请求回调
                break;
        }
    }
}
