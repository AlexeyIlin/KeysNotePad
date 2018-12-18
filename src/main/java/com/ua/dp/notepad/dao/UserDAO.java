package com.ua.dp.notepad.dao;

import com.ua.dp.notepad.entity.User;

import java.util.List;

public interface UserDAO {

    Long addUser(User user);
    void updateUser(User user);
    void deleteUser(Long userId);
    User getUser(Long userId);
    List<User> findUsers();
}
