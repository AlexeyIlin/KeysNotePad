package com.ua.dp.notepad.entity;

public class Content {

    private Long contentId;
    private Long userId;
    private String text;

    public Content(){

    }

    public Content(Long contentId, Long userId, String text) {
        this.contentId = contentId;
        this.userId = userId;
        this.text = text;
    }

    public Content(String text) {
        this.text = text;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentId=" + contentId +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                '}';
    }
}
