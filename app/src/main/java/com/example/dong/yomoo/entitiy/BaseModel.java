package com.example.dong.yomoo.entitiy;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dong on 16/12/2017.
 */

public class BaseModel implements Serializable {
    @SerializedName("created_at")
    protected String createdAt;
    @SerializedName("updated_at")
    protected String updatedAt;

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
