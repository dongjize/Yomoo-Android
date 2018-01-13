package com.example.dong.yomoo.entitiy.users;

import com.example.dong.yomoo.entitiy.BaseModel;

/**
 * Created by dong on 16/12/2017.
 */
public class User extends BaseModel {
    protected Long id; // PK

    protected String phone;
    protected String name;
    protected String password;
    protected String salt;
    protected String type;
    protected String intro;

    public static final String FARMER = "farmer";
    public static final String VENDOR = "vendor";
    public static final String BUTCHER = "butcher";
    public static final String SUPPORTER = "supporter";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
