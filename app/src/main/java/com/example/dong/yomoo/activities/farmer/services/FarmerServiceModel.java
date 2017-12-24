package com.example.dong.yomoo.activities.farmer.services;

/**
 * Created by dong on 23/12/2017.
 */

public class FarmerServiceModel {
    private String title;
    private Class<?> cls;

    public FarmerServiceModel(String title, Class<?> cls) {
        this.title = title;
        this.cls = cls;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }
}
