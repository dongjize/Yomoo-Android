package com.example.dong.yomoo.entities;

import com.example.dong.yomoo.entities.users.User;
import com.google.gson.annotations.SerializedName;

public class FodderOfVendor extends BaseModel {

    private long id;
    private Fodder fodder;
    private User vendor;
    @SerializedName("sell_price")
    private float sellPrice; // 售价，由FodderPurchase而来
    private int stock; // 库存

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

    public User getVendor() {
        return vendor;
    }

    public void setVendor(User vendor) {
        this.vendor = vendor;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
