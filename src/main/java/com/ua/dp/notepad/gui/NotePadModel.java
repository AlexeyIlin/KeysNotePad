package com.ua.dp.notepad.gui;

import com.ua.dp.notepad.entity.Content;
import com.ua.dp.notepad.entity.User;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class NotePadModel extends AbstractTableModel {

    private static final String[] headers = {"ID","UserID","Name", "Login" , "Password", "URL"};

    private final List<Content> contents;
    private final List<User> users;

    public NotePadModel(List<Content> contents, List<User> users){
        this.contents = contents;
        this.users = users;
    }

    @Override
    public int getRowCount(){
        return contents.size();
    }

    @Override
    public int getColumnCount(){
        return 6;
    }

    @Override
    public String getColumnName(int col){
        return headers[col];
    }

    @Override
    public Object getValueAt(int row, int col){
        Content content = contents.get(row);
        User user = users.get(row);
        switch (col){
            case 0:
            return content.getContentId().toString();
            case 1:
                return user.getUserId().toString();
            case 2:
                return user.getName();
            case 3:
                return user.getLogin();
            case 4:
                return user.getPassword();
            default:
                return content.getText();
        }
    }

}
