package com.example.dong.yomoo.entitiy;

import com.google.gson.annotations.SerializedName;

/**
 * Description:
 *
 * @Author: dong
 * @Date: 2017-12-25
 * @Time: 21:42
 */
public class Fodder extends BaseModel {
    private Long id;
    private String name; // 饲料名称，key
    @SerializedName("fodder_spec")
    private String fodderSpec; // 饲料规格，key
    private String description; //饲料描述

    public Fodder() {
    }

    public Fodder(String name, String fodderSpec) {
        this.name = name;
        this.fodderSpec = fodderSpec;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFodderSpec() {
        return fodderSpec;
    }

    public void setFodderSpec(String fodderSpec) {
        this.fodderSpec = fodderSpec;
    }

    @Override
    public String toString() {
        return getName() + " " + getFodderSpec();
    }
}
