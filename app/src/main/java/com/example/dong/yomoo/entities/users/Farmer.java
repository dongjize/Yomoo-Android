package com.example.dong.yomoo.entities.users;

/**
 * Created by dong on 16/12/2017.
 */

public class Farmer extends User {
    private long farmerId; // PK

    private String village;
    private String group;
    private String streetNum;
    private String livestock;
    private String expLivestock;

    public Farmer() {
        setType(FARMER);
    }

    public Farmer(User user) {
        setId(user.getId());
        setPhone(user.getPhone());
        setPassword(user.getPassword());
        setSalt(user.getSalt());
    }

    public long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(long farmerId) {
        this.farmerId = farmerId;
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
