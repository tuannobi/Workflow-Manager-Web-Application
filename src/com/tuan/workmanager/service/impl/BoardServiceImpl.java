package com.tuan.workmanager.service.impl;

import com.tuan.workmanager.dao.BoardDao;
import com.tuan.workmanager.dao.impl.BoardDaoImpl;
import com.tuan.workmanager.model.Board;
import com.tuan.workmanager.service.BoardService;

import java.util.List;

public class BoardServiceImpl implements BoardService {

    BoardDao boardDao=new BoardDaoImpl();

    @Override
    public boolean checkDuplicateTitle(String title, int userId) {
        return boardDao.checkDuplicateTitle(title,userId);
    }

    @Override
    public boolean insertBoard(Board board) {
        if (boardDao.checkDuplicateTitle(board.getTile(),board.getUserId())==false){
            boardDao.insert(board);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Board> getAllByIdUser(int userId) {
        return boardDao.getAllByIdUser(userId);
    }
}
