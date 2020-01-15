package com.tuan.workmanager.dao;

import com.tuan.workmanager.model.Board;

import java.util.List;

public interface BoardDao {
    void insert(Board board);
    void update(Board board);
    void delete(int boardId, int userId);
    void deleteAll(int userId);
    Board getBoard(int boardId, int userId);
    List<Board> getAllByIdUser(int userId);
    boolean checkDuplicateTitle(String title, int userId);
}
