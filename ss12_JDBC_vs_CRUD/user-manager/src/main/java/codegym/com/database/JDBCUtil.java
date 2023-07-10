package codegym.com.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
    public static Connection getConnection() throws Exception{
        Connection connection = null;
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String url = "jdbc:mySQL://127.0.0.1:3306/demo";
        String name = "root";
        String password = "123456";
        connection = DriverManager.getConnection(url,name,password);
        System.out.println("THANH CONG");
        return  connection;
    }

}
