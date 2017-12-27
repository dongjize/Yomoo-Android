package com.example.dong.yomoo.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Description:
 *
 * @Author: dong
 * @Date: 2017-12-25
 * @Time: 21:42
 */
public class Fodder extends BaseModel {

    private long id;
    private String name;
    private String description;
    @SerializedName("fodder_spec")
    private String fodderSpec; // 规格

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
