package com.example.dong.yomoo.entitiy.users;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dong on 16/12/2017.
 */

public class Farmer extends User {

    private String village;
    private String group;
    @SerializedName("street_num")
    private String streetNum;
    private String livestock;
    @SerializedName("exp_livestock")
    private String expLivestock;

    public Farmer() {
    }

    public Farmer(User user) {
        setId(user.getId());
        setPhone(user.getPhone());
        setPassword(user.getPassword());
        setSalt(user.getSalt());
        setType(user.getType());
        setName(user.getName());
        setIntro(user.getIntro());
    }

    public String getAddress() {
        return getVillage() + " " + getGroup() + " " + getStreetNum();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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
