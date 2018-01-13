package com.example.dong.yomoo.entitiy;

import com.example.dong.yomoo.entitiy.users.User;

/**
 * 养殖技术服务需求
 */

public class BreedingInfoDemand extends BaseModel {
    private Long id;
    private String title;
    private String content;
    private User publisher; // 发布需求的farmer

    public BreedingInfoDemand() {
    }

    public BreedingInfoDemand(String title, String content, User publisher) {
        this.title = title;
        this.content = content;
        this.publisher = publisher;
    }

    public BreedingInfoDemand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
