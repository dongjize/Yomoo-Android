package com.example.dong.yomoo.http;

/**
 * Created by dong on 16/12/2017.
 */

public interface HttpCallback {

    void onSuccess(BaseResult result);

    void onFailure(String errMsg);
}
