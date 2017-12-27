package com.example.dong.yomoo.entities;

import com.google.gson.annotations.SerializedName;

public class PurchaseEntry {
    private long id;

    private Fodder fodder;

    @SerializedName("purchase_price")
    private float purchasePrice; //进价

    private int quantity; // 根据这个字段，在fodder表中增加数据

    @SerializedName("sell_price")
    private int sellPrice; // 准备销售的价格

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

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
}
