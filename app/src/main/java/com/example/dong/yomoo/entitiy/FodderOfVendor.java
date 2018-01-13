package com.example.dong.yomoo.entitiy;

import com.example.dong.yomoo.entitiy.users.User;
import com.google.gson.annotations.SerializedName;

public class FodderOfVendor extends BaseModel {

    private Long id;
    private Fodder fodder;
    private User vendor;
    @SerializedName("sell_price")
    private float sellPrice; // 售价，由FodderPurchase而来
    private int stock; // 库存

    public FodderOfVendor() {
    }

    public FodderOfVendor(Fodder fodder, User vendor, float sellPrice, int stock) {
        this.fodder = fodder;
        this.vendor = vendor;
        this.sellPrice = sellPrice;
        this.stock = stock;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
