package com.example.dong.yomoo.entitiy;

import com.example.dong.yomoo.entitiy.users.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Purchase extends BaseModel {

    private Long id;
    @SerializedName("purchase_entries")
    private List<PurchaseEntry> purchaseEntries; // 与PurchaseEntry一对多
    @SerializedName("buyer")
    private User buyer; // 买家，即饲料销售商
    private String tips;

    @SerializedName("total_price")
    private float totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PurchaseEntry> getPurchaseEntries() {
        return purchaseEntries;
    }

    public void setPurchaseEntries(List<PurchaseEntry> purchaseEntries) {
        this.purchaseEntries = purchaseEntries;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

}











