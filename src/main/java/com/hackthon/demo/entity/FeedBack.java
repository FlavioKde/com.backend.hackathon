package com.hackthon.demo.entity;

public class FeedBack {

    private long id;
    private long userId;
    private String hoodName;
    private String content;

    public FeedBack(long id, long userId, String hoodName, String content) {
        this.id = id;
        this.userId = userId;
        this.hoodName = hoodName;
        this.content = content;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getHoodName() {
        return hoodName;
    }

    public void setHoodName(String hoodName) {
        this.hoodName = hoodName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
