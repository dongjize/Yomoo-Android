package com.example.dong.yomoo.entitiy;

import com.example.dong.yomoo.entitiy.users.Farmer;
import com.example.dong.yomoo.entitiy.users.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 饲料订单
 */
public class Order extends BaseModel {

    private Long id;

    @SerializedName("order_entries")
    private List<OrderEntry> orderEntries; // 订单条目，一对多

    @SerializedName("buyer")
    private Farmer buyer; // 养殖户，多对一

    @SerializedName("vendor")
    private User vendor; // 销售商，多对一

    @SerializedName("order_type")
    private String orderType; // 订单类型，owed / payed

    private String tips;

    @SerializedName("total_price")
    private float totalPrice;

    public static final String OWED_ORDER = "owed";
    public static final String PAYED_ORDER = "payed";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderEntry> getOrderEntries() {
        return orderEntries;
    }

    public void setOrderEntries(List<OrderEntry> orderEntries) {
        this.orderEntries = orderEntries;
    }

    public Farmer getBuyer() {
        return buyer;
    }

    public void setBuyer(Farmer buyer) {
        this.buyer = buyer;
    }

    public User getVendor() {
        return vendor;
    }

    public void setVendor(User vendor) {
        this.vendor = vendor;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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
