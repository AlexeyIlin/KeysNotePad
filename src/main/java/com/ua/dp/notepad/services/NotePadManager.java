package com.ua.dp.notepad.services;

import com.ua.dp.notepad.dao.ContentDAO;
import com.ua.dp.notepad.dao.DAOFactory;
import com.ua.dp.notepad.dao.entity.Content;

import java.util.List;

public class NotePadManager {

    private ContentDAO dao;

    public NotePadManager(){
        dao = DAOFactory.getContentDAO();
    }

    public Long addContent(Content content){
        return dao.addContent(content);
    }

    public void updateContent(Content content){
        dao.updateContent(content);
    }

    public void deleteContent(Long contentId){
        dao.deleteContent(contentId);
    }

    public Content getContent(Long contentId){
        return dao.getContent(contentId);
    }

    public List<Content> findContents(){
        return dao.findContents();
    }

}
