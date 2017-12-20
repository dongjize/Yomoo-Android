package com.example.dong.yomoo.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dong on 16/12/2017.
 */

public class BaseModel implements Serializable {
    protected Long id;
    @SerializedName("created_at")
    protected String createdAt;
    @SerializedName("updated_at")
    protected String updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
