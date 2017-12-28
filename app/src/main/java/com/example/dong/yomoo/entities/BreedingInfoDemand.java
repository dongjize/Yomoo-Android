package com.example.dong.yomoo.entities;

import com.example.dong.yomoo.entities.users.User;

/**
 * 养殖技术服务需求
 */

public class BreedingInfoDemand extends BaseModel {
    private long id;
    private String title;
    private String content;
    private User publisher; // 发布需求的farmer

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }
}
