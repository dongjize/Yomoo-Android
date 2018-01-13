package com.example.dong.yomoo.entitiy.users;

import com.example.dong.yomoo.entitiy.BaseModel;

import java.util.Date;

/**
 * Created by dong on 21/12/2017.
 */
public class LoginTicket extends BaseModel {
    private long userId;
    private Date expired;
    private int status;// 0有效，1无效
    private String ticket;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
