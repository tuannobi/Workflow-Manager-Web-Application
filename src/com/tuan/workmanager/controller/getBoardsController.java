package com.tuan.workmanager.controller;

import com.tuan.workmanager.model.Board;
import com.tuan.workmanager.model.User;
import com.tuan.workmanager.service.BoardService;
import com.tuan.workmanager.service.impl.BoardServiceImpl;
import com.tuan.workmanager.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/boards")
public class getBoardsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardService boardService=new BoardServiceImpl();
        Object user=req.getSession().getAttribute("user");
        int userId=((User) user).getUserId();
        List<Board> boards =boardService.getAllByIdUser(userId);
        req.setAttribute("boardList",boards);
        req.getRequestDispatcher(Constant.Path.BOARDS).forward(req,resp);
    }
}
