package com.tuan.workmanager.service.impl;

import com.tuan.workmanager.dao.UserDao;
import com.tuan.workmanager.dao.impl.UserDaoImpl;
import com.tuan.workmanager.model.User;
import com.tuan.workmanager.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao= new UserDaoImpl();
    @Override
    public boolean register(User newUser) {
        if (userDao.checkExistEmail(newUser.getEmail())){
            return false;
        }
        userDao.insert(newUser);
        return true;
    }

    public boolean checkExistEmail(String email){
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean login(String email, String password) {
        return userDao.checkExistEmailAndPassWord(email,password);
    }
}
