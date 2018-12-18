package com.ua.dp.notepad.dao;

import com.ua.dp.notepad.entity.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDAOimpl implements UserDAO{

    private final List<User> users = new ArrayList<User>();

    public UserDAOimpl(){

    }

    @Override
    public Long addUser(User user){
        Long userId = generateUserId();
        user.setUserId(userId);
        users.add(user);
        return userId;
    }

    @Override
    public void updateUser(User user){
        User oldUser = getUser(user.getUserId());
        if (oldUser != null){
            oldUser.setName(user.getName());
            oldUser.setLogin(user.getLogin());
            oldUser.setPassword(user.getPassword());
        }
    }

    @Override
    public void deleteUser(Long userId){
        for(Iterator<User> it = users.iterator(); it.hasNext();){
            User cnt = it.next();
            if (cnt.getUserId().equals(userId)){
                it.remove();
            }
        }
    }

    @Override
    public User getUser(Long userId){
        for (User user: users) {
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findUsers(){
        return users;
    }



    private Long generateUserId(){
        Long userId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        while(getUser(userId) != null) {
            userId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        }
        return userId;
    }



}
