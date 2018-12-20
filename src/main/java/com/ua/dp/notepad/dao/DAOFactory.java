package com.ua.dp.notepad.dao;

import com.ua.dp.notepad.dao.impl.ContentDAOimpl;

public class DAOFactory {

    public static ContentDAO getContentDAO(){
        return new ContentDAOimpl();
    }


}
