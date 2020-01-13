package com.tuan.workmanager.service;

import com.tuan.workmanager.model.User;

public interface UserService {
    boolean register(User newUser);
    boolean checkExistEmail(String email);
    boolean login(String email, String password);
}
