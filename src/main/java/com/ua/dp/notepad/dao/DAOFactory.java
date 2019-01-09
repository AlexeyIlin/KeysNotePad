package com.ua.dp.notepad.dao;

import com.ua.dp.notepad.dao.impl.fileAccessDao.FileContentDAOImpl;

public class DAOFactory {

    public static ContentDAO getContentDAO(){
        return new FileContentDAOImpl();
    }


}
