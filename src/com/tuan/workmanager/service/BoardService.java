package com.tuan.workmanager.service;

import com.tuan.workmanager.model.Board;

import java.util.List;

public interface BoardService {
    boolean checkDuplicateTitle(String title, int userId);
    boolean insertBoard(Board board);
    List<Board> getAllByIdUser(int userId);
}
