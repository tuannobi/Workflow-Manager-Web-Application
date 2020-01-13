package com.tuan.workmanager.controller;

import com.tuan.workmanager.service.UserService;
import com.tuan.workmanager.service.impl.UserServiceImpl;
import com.tuan.workmanager.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login/process")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String alertMsg="";
        UserService userService=new UserServiceImpl();
        if (userService.checkExistEmail(email)){
            boolean isLogin=userService.login(email,password); //login
            if (isLogin){
                resp.sendRedirect(req.getContextPath()+ Constant.Path.urlBoards);
            }else{
                alertMsg="Nhập sai mật khẩu";
                req.getSession().setAttribute("alert",alertMsg);
                req.getSession().setMaxInactiveInterval(1);
                resp.sendRedirect(req.getContextPath()+ Constant.Path.urlLOGIN);
            }
        }else{
            alertMsg="Email không tồn tại";
            req.getSession().setAttribute("alert",alertMsg);
            req.getSession().setMaxInactiveInterval(1);
            resp.sendRedirect(req.getContextPath()+ Constant.Path.urlLOGIN);
        }
    }
}
