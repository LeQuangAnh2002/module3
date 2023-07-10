package codegym.com.test;



import codegym.com.dao.UserDAO;
import codegym.com.database.JDBCUtil;
import codegym.com.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestJDBCUtil {
    public static void main(String[] args) throws SQLException {
        //Bước 1: tạo kết nối
        Connection connection = JDBCUtil.getConnection();
//        //Bước 2: TẠO RA ĐỐI TƯỢNG STATEMENT
//        Statement st = connection.createStatement();
//        //Bước 3: THỰC THI MỘT CÂU LỆNH SQL
//        String sql = "Insert into user(name,email,country) values(\"Anh\",\"quangngocbqn@gmail.com\",\"USD\")";
//
//        int check = st.executeUpdate(sql);
//        //Bước 4: Xử lý kết quả
//        System.out.println("Số dòng thay đổi"+ check);
//        if(check > 0){
//            System.out.println("Thêm dữ liệu thành công");
//        }else{
//            System.out.println("Thêm dữ liệu thất bại");
//        }
        UserDAO userDAO = new UserDAO();
        //Insert
//        User user = new User("anh","anhle@gmail.com","Korea");
//        userDAO.add(user);
        //Update
//        User user = new User(6,"anh","anhle@gmail.com","New York");
//        userDAO.update(user);
        //delete
//        User find = new User();
//        find.setId(6);
//        userDAO.delete(find);
        //findAll
//        ArrayList<User> users = userDAO.selectAll();
//        for (User user : users){
//           System.out.println( user.toString());
//        }
        //findById

        User find = new User();
        find.setId(1);

      User users =  userDAO.selectById(find);
       System.out.println(users.toString());
       //Bước 5: ngắt kết nối
        JDBCUtil.closeConnection(connection);

    }
}
