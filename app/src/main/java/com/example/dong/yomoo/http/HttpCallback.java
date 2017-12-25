package com.example.dong.yomoo.http;

/**
 * Created by dong on 16/12/2017.
 */

public interface HttpCallback<T> {

    void onSuccess(BaseResult<T> result);

    void onFailure(String errMsg);
}
