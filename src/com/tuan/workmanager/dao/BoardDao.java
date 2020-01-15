package com.tuan.workmanager.dao;

import com.tuan.workmanager.model.Board;

import java.util.List;

public interface BoardDao {
    void insert(Board board);
    List<Board> getAllByIdUser(int userId);
    boolean checkDuplicateTitle(String title, int userId);
}
