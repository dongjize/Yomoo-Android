package com.example.dong.yomoo.activities.farmer.fragments.profile;

import android.os.Bundle;

/**
 * Created by dong on 22/12/2017.
 */

public class FarmerProfileModel {
    private String title;
    private Class<?> cls;

    public FarmerProfileModel(String title, Class<?> cls) {
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
