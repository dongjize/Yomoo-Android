package com.example.dong.yomoo.entitiy;

import com.google.gson.annotations.SerializedName;

public class PurchaseEntry {
    private Long id;
    private Fodder fodder; // key，多对一
    @SerializedName("purchase_id")
    private Long purchaseId; // key，多对一
    private int quantity; // 根据这个字段，在fodder表中增加数据
    @SerializedName("purchase_price")
    private float purchasePrice; //进价
    @SerializedName("sell_price")
    private float sellPrice; // 准备销售的价格

    public PurchaseEntry() {
    }

    public PurchaseEntry(Fodder fodder, int quantity, float purchasePrice, float sellPrice) {
        this.fodder = fodder;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Fodder getFodder() {
        return fodder;
    }

    public void setFodder(Fodder fodder) {
        this.fodder = fodder;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

}
