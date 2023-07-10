package codegym.com.dao;

import codegym.com.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
     void insertUser(User user) throws SQLException;
    User selectUser(int id);
    List<User> findAll();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    List<User> findByCountry(String country);
    List<User> searchSapXep(String country);
    List<User> sapXepTheoName();
}
