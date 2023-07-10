package codegym.com.view;

import codegym.com.database.JDBCUtil;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection connection = JDBCUtil.getConnection();
    }
}
