package com.example.dong.yomoo.entities;

import com.example.dong.yomoo.entities.users.Farmer;
import com.example.dong.yomoo.entities.users.User;

/**
 * Created by dong on 16/12/2017.
 */

public class FodderOrder extends BaseModel {

    private Farmer farmer;
    private User vendor;
    private Fodder fodder;
    private String fodderSpec;
    private int fodderCount;
    private OrderType orderType;
    private String tips;

    enum OrderType {
        PAYED, OWED
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public User getVendor() {
        return vendor;
    }

    public void setVendor(User vendor) {
        this.vendor = vendor;
    }

    public Fodder getFodder() {
        return fodder;
    }

    public void setFodder(Fodder fodder) {
        this.fodder = fodder;
    }

    public String getFodderSpec() {
        return fodderSpec;
    }

    public void setFodderSpec(String fodderSpec) {
        this.fodderSpec = fodderSpec;
    }

    public int getFodderCount() {
        return fodderCount;
    }

    public void setFodderCount(int fodderCount) {
        this.fodderCount = fodderCount;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
