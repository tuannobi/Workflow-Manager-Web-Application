package com.tuan.workmanager.jdbc;

import java.sql.*;

public class JDBCConnection {

    public static Connection getJDBCConection(){
        Connection conn=null;
        try{
            String user="workflowmanagement";
            String password="workflowmanagement";
            String databaseName="workflow_management";
            String url="jdbc:mysql://localhost:3306/"+databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn, Statement sttm, ResultSet rs) {
        try{
            if (rs!= null){
                rs.close();
            }
            if (sttm !=null){
                sttm.close();
            }
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
