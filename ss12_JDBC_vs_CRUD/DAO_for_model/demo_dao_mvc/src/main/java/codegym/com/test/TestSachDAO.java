package codegym.com.test;

import codegym.com.dao.SachDAO;
import codegym.com.model.Sach;

import java.util.ArrayList;

public class TestSachDAO {
    public static void main(String[] args) {
        //test Insert
//        Sach sach1 = new Sach("LTJV","Lập trình java","50000",2025);
//        Sach sach2 = new Sach("LTC+","Lập trình C++","250000",2024);

//        for (int i = 2 ; i < 100; i++){
//            Sach sach = new Sach("LT"+i,"Lập trình "+i,"20000",2025);
//            SachDAO.getInstance().add(sach);
//        }
            //Test update
//        Sach sach = new Sach("LTJV","Lập trình java","1000000",2025);
//        SachDAO.getInstance().upd ate(sach);


        //Test DELETE
//        for (int i = 2 ; i < 100; i++){
//            Sach sach = new Sach("LT"+i,"Lập trình "+i,"20000",2025);
//            SachDAO.getInstance().delete(sach);
//        }

        //Test findAll()
//        ArrayList<Sach> list = SachDAO.getInstance().selectAll();
//        for (Sach sach : list){
//            System.out.println(sach.toString());
//        }
        //Test findByID
//        System.out.println();
//        Sach find = new Sach();
//        find.setId("LTC+");
//        Sach sach2 = SachDAO.getInstance().selectById(find);
//        System.out.println(sach2);
        //Test condition
        ArrayList<Sach> list2 = SachDAO.getInstance().selectByCondition("gia_ban > 250000");
        for(Sach sach : list2) {
            System.out.println(sach.toString());
        }
    }




    }


