package com.ua.dp.notepad.entity;

public class User {

    private Long userId;
    private String login;
    private String password;
    private String name;

    public User() {
    }

    public User(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public User(Long userId, String login, String password, String name) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public User(String name){
        this.name=name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
