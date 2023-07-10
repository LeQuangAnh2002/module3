package codegym.com.dao;

import codegym.com.database.JDBCUtil;
import codegym.com.model.Sach;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SachDAO implements DAOInterface<Sach>{
    public static  SachDAO getInstance(){
        return new SachDAO();
    }
    @Override
    public int add(Sach sach) {
        int ketQua;
        try {
            //Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();
            //Bước 2: tạo ra 1 đối tượng statement
            Statement statement = con.createStatement();
            //Bước 3: thực thi câu lệnh SQL;
            String sql = "Insert into sach(id,ten_sach,gia_ban,nam_xuat_ban) " +
                    " values('"+sach.getId()+"' , '"+ sach.getTenSach()+"' , '"+sach.getGiaBan()+"' , '"+ sach.getNamSanXuat()+ "' )";

                     ketQua = statement.executeUpdate(sql);
                    // bước 4 : xử lý
            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có "+ ketQua + " dòng bị thay đổi");
                //bước 5:
               con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int update(Sach sach) {
        int ketQua;
        try {
            //Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();
            //Bước 2: tạo ra 1 đối tượng statement
            Statement statement = con.createStatement();
            //Bước 3: thực thi câu lệnh SQL;

            String sql = "UPDATE sach " +
                    " Set "+
                    " ten_sach= '"+ sach.getTenSach()+"'"+
                    ", gia_ban= '"+ sach.getGiaBan()+"'" +
                    ", nam_xuat_ban= '"+sach.getNamSanXuat()+"'" +
                    " Where id = '"+sach.getId()+"\'";
            System.out.println(sql);
            ketQua = statement.executeUpdate(sql);
            // bước 4 : xử lý
            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có "+ ketQua + " dòng bị thay đổi");
            //bước 5:
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int delete(Sach sach) {
        int ketQua;
        try {
            //Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();
            //Bước 2: tạo ra 1 đối tượng statement
            Statement statement = con.createStatement();
            //Bước 3: thực thi câu lệnh SQL;

            String sql = "DELETE FROM sach " +
                    " Where id = '"+sach.getId()+"\'";
            System.out.println(sql);
            ketQua = statement.executeUpdate(sql);
            // bước 4 : xử lý
            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có "+ ketQua + " dòng bị thay đổi");
            //bước 5:
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> ketQua = new ArrayList<Sach>();
        try {
            //Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();
            //Bước 2: tạo ra 1 đối tượng statement
            Statement statement = con.createStatement();
            //Bước 3: thực thi câu lệnh SQL;

            String sql = "SELECT * FROM  sach";
             ResultSet resultSet = statement.executeQuery(sql);
            // bước 4 : xử lý
            while (resultSet.next()){
                    String id = resultSet.getString("id");
                    String ten_sach = resultSet.getString("ten_sach");
                    String gia_ban = resultSet.getString("gia_ban");
                    int nam_xuat_ban = resultSet.getInt("nam_xuat_ban");

                Sach sach = new Sach(id,ten_sach,gia_ban,nam_xuat_ban);
                ketQua.add(sach);
            }


            //bước 5:
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public Sach selectById(Sach sach) {
       Sach ketQua = null;

        try {
            //Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();
            //Bước 2: tạo ra 1 đối tượng statement
            Statement statement = con.createStatement();
            //Bước 3: thực thi câu lệnh SQL;

            String sql = "SELECT * FROM  sach where id= '"+sach.getId()+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            // bước 4 : xử lý
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String ten_sach = resultSet.getString("ten_sach");
                String gia_ban = resultSet.getString("gia_ban");
                int nam_xuat_ban = resultSet.getInt("nam_xuat_ban");

                ketQua = new Sach(id,ten_sach,gia_ban,nam_xuat_ban);

            }


            //bước 5:
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        ArrayList<Sach> ketQua = new ArrayList<Sach>();
        try {
            //Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();
            //Bước 2: tạo ra 1 đối tượng statement
            Statement statement = con.createStatement();
            //Bước 3: thực thi câu lệnh SQL;

            String sql = "SELECT * FROM  sach where "+ condition;
            ResultSet resultSet = statement.executeQuery(sql);
            // bước 4 : xử lý
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String ten_sach = resultSet.getString("ten_sach");
                String gia_ban = resultSet.getString("gia_ban");
                int nam_xuat_ban = resultSet.getInt("nam_xuat_ban");

                Sach sach = new Sach(id,ten_sach,gia_ban,nam_xuat_ban);
                ketQua.add(sach);
            }


            //bước 5:
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
}
