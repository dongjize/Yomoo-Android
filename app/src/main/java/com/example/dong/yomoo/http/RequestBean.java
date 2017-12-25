package com.example.dong.yomoo.http;

import java.util.Map;

/**
 * Created by dong on 16/12/2017.
 */

public class RequestBean {
    private String tag;
    private String url;
    private Map<String, Object> params;

    public RequestBean(String tag, String url, Map<String, Object> params) {
        this.tag = tag;
        this.url = url;
        this.params = params;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Map<?, ?> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
