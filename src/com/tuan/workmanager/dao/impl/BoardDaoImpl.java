package com.tuan.workmanager.dao.impl;

import com.tuan.workmanager.dao.BoardDao;
import com.tuan.workmanager.jdbc.JDBCConnection;
import com.tuan.workmanager.model.Board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl extends JDBCConnection implements BoardDao {
    @Override
    public void insert(Board board) {
        String sql="insert into board(title,description,created_date,user_id,start_date,end_date)" +
                "values(?,?,?,?,?,?)";
        Connection conn=null;
        PreparedStatement statement=null;
        try{
            conn= getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setString(1,board.getTile());
            statement.setString(2,board.getDescription());
            statement.setTimestamp(3, new Timestamp(board.getCreatedDate().getTime()));
            statement.setInt(4,board.getUserId());
            statement.setTimestamp(5, new Timestamp(board.getStartDate().getTime()));
            statement.setTimestamp(6, new Timestamp(board.getEndDate().getTime()));
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(conn,statement,null);
        }
    }

    @Override
    public void update(Board board) {
        String sql="update board set title=?, description=?, modified_lastest_date=?,start_date=?,end_date=? " +
                "where user_id=? and board_id=?";
        Connection conn=null;
        PreparedStatement statement=null;
        try{
            conn=super.getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setString(1,board.getTile());
            statement.setString(2,board.getDescription());
            statement.setTimestamp(3, new Timestamp(board.getModifiedLastestDate().getTime()) );
            statement.setTimestamp(4, new Timestamp(board.getStartDate().getTime()));
            statement.setTimestamp(5, new Timestamp(board.getEndDate().getTime()));
            statement.setInt(6,board.getUserId());
            statement.setInt(7,board.getBoardId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int boardId, int userId) {
        String sql="delete from board where board_id=? and user_id=?";
        Connection conn=null;
        PreparedStatement statement;
        try{
            conn=super.getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setInt(1,boardId);
            statement.setInt(2,userId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll(int userId) {
        String sql="delete from board where user_id=?";
        Connection conn=null;
        PreparedStatement statement=null;
        try{
            conn=super.getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Board getBoard(int boardId, int userId) {
        String sql="select * from board where board_id=? and user_id=?";
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet rs=null;
        Board board=null;
        try{
            conn=super.getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setInt(1,boardId);
            statement.setInt(2,userId);
            rs=statement.executeQuery();
            if (rs.next()){
                board=new Board();
               board.setBoardId(rs.getInt("board_id"));
               board.setTile(rs.getString("title"));
               board.setDescription(rs.getString("description"));
               board.setCreatedDate(rs.getTimestamp("created_date"));
               board.setModifiedLastestDate(rs.getTimestamp("modified_lastest_date"));
               board.setUserId(rs.getInt("user_id"));
               board.setStartDate(rs.getTimestamp("start_date"));
               board.setEndDate(rs.getTimestamp("end_date"));
            }
            return board;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Board> getAllByIdUser(int userId) {
        List<Board> boards=null;
        String sql="select * from board where user_id=?";
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet rs=null;
        try{
            boards=new ArrayList<Board>();
            conn= getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setInt(1,userId);
            rs=statement.executeQuery();
            while(rs.next()){
                boards.add(new Board(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getTimestamp(4),
                rs.getTimestamp(5),
                rs.getInt(6),
                rs.getTimestamp(7),
                rs.getTimestamp(8)));
            }
            return boards;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkDuplicateTitle(String title, int userId) {
        String sql="select * from board where title=? and user_id=?";
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet rs=null;
        try{
            conn= getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setString(1,title);
            statement.setInt(2,userId);
            rs=statement.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(conn,statement,rs);
        }
        return false;
    }

}
