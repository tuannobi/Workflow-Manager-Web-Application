package com.tuan.workmanager.controller;

import com.tuan.workmanager.model.User;
import com.tuan.workmanager.service.UserService;
import com.tuan.workmanager.service.impl.UserServiceImpl;
import com.tuan.workmanager.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String displayName=req.getParameter("displayName");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        UserService userService=new UserServiceImpl();
        String alertMsg="";
        if (userService.checkExistEmail(email)){
            alertMsg="Email đã tồn tại";
 //           Option1
//            req.setAttribute("alert",alertMsg);
//            req.getRequestDispatcher(Constant.Path.REGISTER).forward(req,resp);
            //Option2
           // resp.sendRedirect(req.getContextPath()+Constant.Path.urlREGISTER+alertMsg);
            //Option3
            req.getSession().setAttribute("alert",alertMsg);
            req.getSession().setMaxInactiveInterval(1);
            resp.sendRedirect(req.getContextPath()+Constant.Path.urlREGISTER);
            return;
        }
        boolean isSucess=userService.register(new User(displayName,email,password));
        System.out.println(isSucess);
        if (isSucess==true){
            alertMsg="Đăng ký thành công";
            req.getSession().setAttribute("alert",alertMsg);
            req.getSession().setMaxInactiveInterval(1);
            resp.sendRedirect(req.getContextPath()+Constant.Path.urlLOGIN);
        }
    }


}
