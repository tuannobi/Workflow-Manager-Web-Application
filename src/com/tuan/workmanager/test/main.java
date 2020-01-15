package com.tuan.workmanager.test;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import com.tuan.workmanager.dao.BoardDao;
import com.tuan.workmanager.dao.UserDao;
import com.tuan.workmanager.dao.impl.BoardDaoImpl;
import com.tuan.workmanager.dao.impl.UserDaoImpl;
import com.tuan.workmanager.model.Board;
import com.tuan.workmanager.model.User;
import com.tuan.workmanager.service.BoardService;
import com.tuan.workmanager.service.impl.BoardServiceImpl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class main {
    public static void main(String[] args) throws ParseException {
        String input="2000-12-12T20:50";
        String date=input.substring(0,input.indexOf("T"));
        String time=input.substring(input.lastIndexOf("T")+1);
        System.out.println(date);
        System.out.println(time);
       Date startDate=new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(date+" "+time);
        System.out.println(startDate);

        BoardService boardService=new BoardServiceImpl();
        Date newDate=new Date();
//        boolean isSucess=boardService.insertBoard(new Board("title","description",newDate,16,newDate,newDate));
//        System.out.println(isSucess);

        System.out.println(new Timestamp(newDate.getTime()));

        BoardDao boardDao=new BoardDaoImpl();
        System.out.println(boardDao.getAllByIdUser(16));

    }
}
