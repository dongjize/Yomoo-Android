package com.example.dong.yomoo.entities;

import java.util.Date;

/**
 * Created by dong on 16/12/2017.
 */

public class FodderPurchase extends BaseModel {
    private int fodderId;
    private Date purchaseTime;
    private int fodderCount;
    private String fodderSpec;

    public int getFodderId() {
        return fodderId;
    }

    public void setFodderId(int fodderId) {
        this.fodderId = fodderId;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getFodderCount() {
        return fodderCount;
    }

    public void setFodderCount(int fodderCount) {
        this.fodderCount = fodderCount;
    }

    public String getFodderSpec() {
        return fodderSpec;
    }

    public void setFodderSpec(String fodderSpec) {
        this.fodderSpec = fodderSpec;
    }
}
