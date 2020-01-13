package com.tuan.workmanager.controller;

import com.tuan.workmanager.model.User;
import com.tuan.workmanager.service.UserService;
import com.tuan.workmanager.service.impl.UserServiceImpl;
import com.tuan.workmanager.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    //Khi nguoi dung truy cap vao url domain/login. Mac dinh se la GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //check user logout or not . Dang xuat thi moi vao trang login duoc
        // Neu con phien dang nhap thi chuyen tiep den Boards
        HttpSession session=req.getSession(false);//neu khong tim thay session thi khong tao moi
        if (session!=null && session.getAttribute("user")!=null){
            resp.sendRedirect(req.getContextPath()+Constant.Path.urlBoards);
            return;
        }

        //neu het phien dang nhap kiem tra xem co cookie hay khong
//        Cookie[] cookies=req.getCookies();
//        if (cookies !=null){
//            for (Cookie cookie:cookies){
//                if (cookie.getName().equals(Constant.COOKIE_REMEMBER)){
//
//                }
//            }
//        }
        req.getRequestDispatcher(Constant.Path.LOGIN).forward(req,resp);
    }

    //Khi nguoi dung chon Submit form la POST
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String alertMsg="";
        boolean isRememberMe=false;
        User user =null;
        UserService userService=new UserServiceImpl();

       if ("on".equals(req.getParameter("remember"))){
           isRememberMe=true;
       }
        if (userService.checkExistEmail(email)){
            user=userService.login(email,password); //login
            if (user!=null){
                if (isRememberMe){
                 //   saveRememberMe(resp,email);
                    Cookie cookie=new Cookie(Constant.COOKIE_REMEMBER,email);
                    cookie.setMaxAge(60*60);
                    resp.addCookie(cookie);
                }
                HttpSession session=req.getSession();
                session.setAttribute("user",user);
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

    private void saveRememberMe(HttpServletResponse resp, String email) {
        Cookie cookie=new Cookie(Constant.COOKIE_REMEMBER,email);
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
    }
}
