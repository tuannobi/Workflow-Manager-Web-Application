package com.tuan.workmanager.dao.impl;

import com.tuan.workmanager.dao.UserDao;
import com.tuan.workmanager.jdbc.JDBCConnection;
import com.tuan.workmanager.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl extends JDBCConnection implements UserDao {

    @Override
    public void insert(User user) {

        String sql="insert into user(display_name,email,password) value(?,?,?)";
        Connection conn=null;
        PreparedStatement statement=null;
        try{
            conn=super.getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setString(1,user.getDisplayName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            super.close(conn,statement,null);
        }
    }

    @Override
    public void update(User user) {
        String sql="update user set display_name=?,email=?,password=? where user_id=?";
        Connection conn=null;
        PreparedStatement statement=null;
        try{
            conn=super.getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setString(1,user.getDisplayName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());
            statement.setInt(4,user.getUserId());
            statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int userId) {
        String sql="delete from user where user_id=?";
        Connection conn=null;
        PreparedStatement statement=null;
        try{
            conn=super.getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(int userId) {
        String sql="select * from user where user_id=?";
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet rs=null;
        User user=null;
        try{
            conn=super.getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.executeQuery();
            if(rs.next()){
                user=new User();
                user.setUserId(rs.getInt("user_id"));
                user.setDisplayName(rs.getString("display_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean checkExistEmail(String email) {
        String sql="select * from user where email=?";
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet rs = null;
        try{
            conn=super.getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setString(1,email);
            rs=statement.executeQuery();
            if (rs.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            super.close(conn,statement,rs);
        }
        return false;
    }

    @Override
    public User checkExistEmailAndPassWord(String email, String password) {
        String sql="select * from user where email=? and password=?";
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet rs=null;
        User user=null;
        try{
            conn=super.getJDBCConection();
            statement=conn.prepareStatement(sql);
            statement.setString(1,email);
            statement.setString(2,password);
            rs=statement.executeQuery();
            if (rs.next()){
               return user=new User(rs.getInt("user_id"),rs.getString("display_name"),rs.getString("email"),rs.getString("password"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            super.close(conn,statement,rs);
        }
        return null;
    }

}
