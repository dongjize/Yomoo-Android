package com.example.dong.yomoo.entities;

import com.example.dong.yomoo.users.User;

import java.util.Date;

/**
 * Created by dong on 16/12/2017.
 */

public class BreedingInfo extends BaseModel {
    private User publisher;
    private String title;
    private String content;
    private Date timestamp;

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
