package com.example.dong.yomoo.activities.vendor;

/**
 * Created by dong on 17/12/2017.
 */

public class VendorHomeModel {
    private String title;
    private String subtitle;
    private Class<?> cls;

    public VendorHomeModel(String title, String subtitle, Class<?> cls) {
        this.title = title;
        this.subtitle = subtitle;
        this.cls = cls;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }
}
