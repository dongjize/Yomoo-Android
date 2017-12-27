package com.example.dong.yomoo.entities;

import com.example.dong.yomoo.entities.users.User;

/**
 * Created by I346748 on 12/27/2017.
 */
public class LivestockDemand extends BaseModel {
    private long id;
    private User publisher;
    private String title;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

}
