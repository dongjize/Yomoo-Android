package com.example.dong.yomoo.users;

import com.example.dong.yomoo.entities.BaseModel;

/**
 * Created by dong on 16/12/2017.
 */

public class User extends BaseModel {
    protected String phone;
    protected String password;
    protected String name;
    protected UserType type;

    public enum UserType {
        FARMER, VENDOR, BUTCHER, SUPPORTER;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
