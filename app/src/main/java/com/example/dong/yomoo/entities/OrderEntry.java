package com.example.dong.yomoo.entities;

import com.google.gson.annotations.SerializedName;

/**
 * 订单条目
 */
public class OrderEntry {

    private long id;
    @SerializedName("fodder_vendor")
    private FodderOfVendor fodderOfVendor;
    private int quantity;
    @SerializedName("sell_price")
    private float sellPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FodderOfVendor getFodderOfVendor() {
        return fodderOfVendor;
    }

    public void setFodderOfVendor(FodderOfVendor fodderOfVendor) {
        this.fodderOfVendor = fodderOfVendor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public String getFodderSpec() {
//        return fodderSpec;
//    }
//
//    public void setFodderSpec(String fodderSpec) {
//        this.fodderSpec = fodderSpec;
//    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }
}
