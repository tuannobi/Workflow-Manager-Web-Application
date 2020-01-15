package com.tuan.workmanager.controller;

import com.google.gson.Gson;
import com.tuan.workmanager.model.Board;
import com.tuan.workmanager.model.User;
import com.tuan.workmanager.service.BoardService;
import com.tuan.workmanager.service.impl.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/createBoard")
public class createNewBoardController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title=req.getParameter("board-popup-create-title");

        String startDateStr=req.getParameter("board-popup-create-body-start");
        String endDateStr=req.getParameter("board-popup-create-body-end");
        String startDateStr_Date="";
        String startDateStr_Time="";
        String endDateStr_Date="";
        String endDateStr_Time="";
        if (startDateStr.equals("")==false){
            startDateStr_Date=startDateStr.substring(0,startDateStr.indexOf("T"));
            startDateStr_Time=startDateStr.substring(startDateStr.lastIndexOf("T")+1);
        }
        if (endDateStr.equals("")==false){
            endDateStr_Date=endDateStr.substring(0,endDateStr.indexOf("T"));
            endDateStr_Time=endDateStr.substring(endDateStr.lastIndexOf("T")+1);
        }


        Date startDate= null;
        Date endDate= null;
        try {
            if (startDateStr_Date.equals("")==false && startDateStr_Time.equals("")==false)
            startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(startDateStr_Date+" "+startDateStr_Time);
            if (endDateStr_Date.equals("")==false && endDateStr_Time.equals("")==false)
            endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(endDateStr_Date+" "+endDateStr_Time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

         String description=req.getParameter("board-popup-create-body-description");
        Object obj=req.getSession().getAttribute("user");
        int userId= ((User) obj).getUserId();
        boolean alertMsg=false;
        String code="";
        BoardService boardService=new BoardServiceImpl();
        if (boardService.checkDuplicateTitle(title,userId)==false){
            Date currentDate=new Date();
            boolean isSucess=boardService.insertBoard(new Board(title,description,currentDate,userId,startDate,endDate));
            if(isSucess){
                alertMsg=true;
                code="<a href=\"#\" class=\"float-left p-2 m-2\">\n" +
                        "                                <div id=\"\" class=\"board-display-group \">\n" +
                        "                                    <h5>"+title+"</h5>\n" +
                        "                                </div>\n" +
                        "                            </a>";
            }else{
                alertMsg=false;
            }
        }


        Map<String, Object> map=new HashMap<String,Object>();
        map.put("alert",alertMsg);
        map.put("code",code);
        PrintWriter pw=resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        pw.write(new Gson().toJson(map));
    }
}
