package com.example.demo_jdbc.codegym.test;

import com.example.demo_jdbc.codegym.database.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCUtil {
    public static void main(String[] args) throws SQLException {
        //Bước 1: tạo kết nối
        Connection connection = JDBCUtil.getConnection();
        //Bước 2: TẠO RA ĐỐI TƯỢNG STATEMENT
        Statement st = connection.createStatement();
        //Bước 3: THỰC THI MỘT CÂU LỆNH SQL
        String sql = "Insert into user(name,email,country) values(\"Anh\",\"quangngocbqn@gmail.com\",\"USD\")";

        int check = st.executeUpdate(sql);
        //Bước 4: Xử lý kết quả
        System.out.println("Số dòng thay đổi"+ check);
        if(check > 0){
            System.out.println("Thêm dữ liệu thành công");
        }else{
            System.out.println("Thêm dữ liệu thất bại");
        }
       //Bước 5: ngắt kết nối
        JDBCUtil.closeConnection(connection);

    }
}
