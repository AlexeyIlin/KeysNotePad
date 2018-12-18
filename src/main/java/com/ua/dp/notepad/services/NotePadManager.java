package com.ua.dp.notepad.services;

import com.ua.dp.notepad.dao.ContentDAO;
import com.ua.dp.notepad.dao.ContentDAOFactory;
import com.ua.dp.notepad.dao.UserDAO;
import com.ua.dp.notepad.dao.UserDAOFactory;
import com.ua.dp.notepad.entity.Content;
import com.ua.dp.notepad.entity.User;

import java.util.List;

public class NotePadManager {

    private ContentDAO dao;
    private UserDAO userDAO;

    public NotePadManager(){
        dao = ContentDAOFactory.getContentDAO();
        userDAO = UserDAOFactory.getUserDAO();
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

    public List<User> findUsers(){
        return userDAO.findUsers();
    }


    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    public User getUser(Long userId){
        return userDAO.getUser(userId);
    }

    public void deleteUser(Long userId){
        userDAO.deleteUser(userId);
    }

    public Long addUser(User user){
        return userDAO.addUser(user);
    }
}
