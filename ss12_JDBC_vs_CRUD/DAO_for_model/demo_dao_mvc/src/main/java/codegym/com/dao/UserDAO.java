package codegym.com.dao;

import codegym.com.database.JDBCUtil;
import codegym.com.model.Sach;
import codegym.com.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements DAOInterface<User>{
    @Override
    public int add(User user) {
        int ketqua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String  sql = "Insert Into User(name,email,country) values(?,?,?,?)";
            //? dùng để ngăn chặn những liên quan đến câu lệnh sql sẽ chặn
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,user.getId());
            // parameterIndex 1 tương ứng với dấu hỏi(?) thứ nhất, user.getId() lấy id nhập vào gắn vào dấu ? thứ nhất
            // trước khi gắp vào ? thứ 1 thì trước đó nó sẽ có 1 sự kiểm tra nếu trong id hoặc name chứa chuỗi là câu lệnh sql thì lập tức bị bỏ qua
            // nên dùng preparedStatement thay vì dùng Statement cách chúng ta truyền dữ liệu vào.
            //an toàn tránh bị tấn công.
            statement.setString(2,user.getName());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getCountry());
            ketqua = statement.executeUpdate();
            System.out.println("Thêm thành công");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public int update(User user) {
        int ketqua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE user Set name= ?, email= ? , country= ? where id= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getCountry());
            ketqua = statement.executeUpdate();
            System.out.println("update thành công");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public int delete(User user) {
        int ketqua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "DELETE from user where id= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,user.getId());
            ketqua = statement.executeUpdate(sql);
            System.out.println("xóa thành công");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            //Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();
            //Bước 2: tạo ra 1 đối tượng statement
            Statement statement = con.createStatement();
            //Bước 3: thực thi câu lệnh SQL;

            String sql = "SELECT * FROM  user";
            ResultSet resultSet = statement.executeQuery(sql);
            // bước 4 : xử lý
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                User user = new User(id,name,email,country);
                ketQua.add(user);
            }


            //bước 5:
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public User selectById(User user) {
        User ketQua = null;
        try {
            //Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();
            //Bước 2: tạo ra 1 đối tượng statement

            //Bước 3: thực thi câu lệnh SQL;

            String sql = "SELECT * FROM  user where id= ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,user.getId());
            ResultSet resultSet = statement.executeQuery();

            // bước 4 : xử lý
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                ketQua = new User(id,name,email,country);

            }


            //bước 5:
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        ArrayList<User> ketQua = new ArrayList<User>();

        return ketQua;
    }
}
