package com.tuan.workmanager.test;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import com.tuan.workmanager.dao.UserDao;
import com.tuan.workmanager.dao.impl.UserDaoImpl;
import com.tuan.workmanager.model.User;

public class main {
    public static void main(String[] args) {
        UserDao userDao= new UserDaoImpl();
        User user=userDao.checkExistEmailAndPassWord("tuancc@gmail.com","123456");
        System.out.println(user.getDisplayName());
        System.out.println(user.getEmail());
    }
}
