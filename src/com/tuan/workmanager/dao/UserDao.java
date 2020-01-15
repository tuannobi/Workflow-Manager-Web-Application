package com.tuan.workmanager.dao;

import com.tuan.workmanager.model.User;

public interface UserDao {
    void insert(User user);
    void update(User user);
    void delete(int userId);
    User getUser(int userId);
    boolean checkExistEmail(String email);
    User checkExistEmailAndPassWord(String email, String password);
}
