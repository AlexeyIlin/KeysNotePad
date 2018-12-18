package com.ua.dp.notepad.dao;

public class ContentDAOFactory {

    public static ContentDAO getContentDAO(){
        return new ContentDAOimpl();
    }
}
