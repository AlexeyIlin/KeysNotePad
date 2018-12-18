package com.ua.dp.notepad.dao;

public class UserDAOFactory {

    public static UserDAO getUserDAO(){
        return new UserDAOimpl();
    }
}
