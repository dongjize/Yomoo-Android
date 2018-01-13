package com.example.dong.yomoo.entitiy;

import com.google.gson.annotations.SerializedName;

/**
 * 订单条目
 */
public class OrderEntry {
    private Long id;

    @SerializedName("fodder_of_vendor")
    private FodderOfVendor fv; // 一对一，一个条目只包含一个饲料

    @SerializedName("order_id")
    private Long orderId; // 订单id，多对一，一个订单包含多个条目

    private int quantity; // 饲料购买数量

    @SerializedName("sell_price")
    private float sellPrice; // 售价

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FodderOfVendor getFv() {
        return fv;
    }

    public void setFv(FodderOfVendor fv) {
        this.fv = fv;
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

    public Long getOrderId() {
        return orderId;
    }
    //
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
