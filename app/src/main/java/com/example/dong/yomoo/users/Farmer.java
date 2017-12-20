package com.example.dong.yomoo.users;

/**
 * Created by dong on 16/12/2017.
 */

public class Farmer extends User {
    private String village;
    private String group;
    private String streetNum;
    private String livestock;
    private String expLivestock;

    public Farmer() {
        this.type = UserType.FARMER;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getLivestock() {
        return livestock;
    }

    public void setLivestock(String livestock) {
        this.livestock = livestock;
    }

    public String getExpLivestock() {
        return expLivestock;
    }

    public void setExpLivestock(String expLivestock) {
        this.expLivestock = expLivestock;
    }
}
