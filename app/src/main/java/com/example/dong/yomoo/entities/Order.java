package com.example.dong.yomoo.entities;

import com.example.dong.yomoo.entities.users.Farmer;
import com.example.dong.yomoo.entities.users.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 饲料订单
 */
public class Order extends BaseModel {

    private long id;
    private List<OrderEntry> orderEntries; // 一对多
    private Farmer buyer; // 养殖户
    private User vendor; // 销售商
    @SerializedName("order_type")
    private String orderType;
    private String tips;

    public static final String OWED_ORDER = "owed";
    public static final String PAYED_ORDER = "payed";

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
