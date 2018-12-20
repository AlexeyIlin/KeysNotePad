package com.ua.dp.notepad.dao.entity;

public class Content {

    private Long contentId;
    private String name;
    private String login;
    private String password;
    private String text;

    public Content(Long contentId, String name, String login, String password,String text ) {
        this.contentId = contentId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.text = text;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    @Override
    public String toString() {
        return "Content{" +
                "contentId=" + contentId +
                ", name='" + name + '\'' +
                ", login=" + login +
                ", password='" + password + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
