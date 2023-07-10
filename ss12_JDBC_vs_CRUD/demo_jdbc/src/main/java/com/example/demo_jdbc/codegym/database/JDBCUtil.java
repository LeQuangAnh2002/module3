package com.example.demo_jdbc.codegym.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() throws SQLException {
        Connection c = null;
        // Đăng ký MySQL Driver với DriverManagement
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //các thông số
        String url = "jdbc:mySQL://127.0.0.1:3306/demo";
        String username = "root";
        String password = "123456";

        //tạo kết nối
        c = DriverManager.getConnection(url, username, password);
        System.out.println("Thành công");
        return c;

    }

    ;

    public static void closeConnection(Connection c) {
        try {
            if(c != null){
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  void printInfo(Connection c) throws SQLException {
        if(c != null){
            DatabaseMetaData mtdt = c.getMetaData();
            System.out.println(mtdt.getDatabaseProductName());
            System.out.println(mtdt.getDatabaseProductVersion());
        }
    }
    }

