package com.ua.dp.notepad.gui;

import com.ua.dp.notepad.dao.entity.Content;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class NotePadModel extends AbstractTableModel {

    private static final String[] headers = {"ID","Name", "Login" , "Password", "URL"};

    private final List<Content> contents;

    public NotePadModel(List<Content> contents){
        this.contents = contents;
    }

    @Override
    public int getRowCount(){
        return contents.size();
    }

    @Override
    public int getColumnCount(){
        return 5;
    }

    @Override
    public String getColumnName(int col){
        return headers[col];
    }

    @Override
    public Object getValueAt(int row, int col){
        Content content = contents.get(row);
        switch (col){
            case 0:
            return content.getContentId().toString();
            case 1:
                return content.getName();
            case 2:
                return content.getLogin();
            case 3:
                return content.getPassword();
            default:
                return content.getText();
        }
    }

}
