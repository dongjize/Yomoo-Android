package com.example.dong.yomoo.entities;

import com.example.dong.yomoo.entities.users.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Purchase extends BaseModel {

    private long id;
    @SerializedName("purchase_entries")
    private List<PurchaseEntry> purchaseEntries; // 与PurchaseEntry一对多
    private User vendor; // 买家，即饲料销售商
    private String tips;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PurchaseEntry> getPurchaseEntries() {
        return purchaseEntries;
    }

    public void setPurchaseEntries(List<PurchaseEntry> purchaseEntries) {
        this.purchaseEntries = purchaseEntries;
    }

    public User getVendor() {
        return vendor;
    }

    public void setVendor(User vendor) {
        this.vendor = vendor;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}











