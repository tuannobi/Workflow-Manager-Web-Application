package com.tuan.workmanager.dao;

import com.tuan.workmanager.model.User;

public interface UserDao {
    void insert(User user);
    boolean checkExistEmail(String email);
    boolean checkExistEmailAndPassWord(String email, String password);
}
