package codegym.com.Repository;

import codegym.com.Model.Producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProducerRepositoryImpl implements ProducerRepository{
    private static Map<Integer,Producer> categoryMap;
    static {
        categoryMap = new HashMap<>();
        categoryMap.put(1, new Producer(1,"Thời Trang"));
        categoryMap.put(2, new Producer(2,"Đồng Hồ"));
        categoryMap.put(3, new Producer(3,"Thiết Bị Điện Tử"));
        categoryMap.put(4, new Producer(4,"Sắc Đẹp"));
        categoryMap.put(5, new Producer(5,"Điện Thoại"));


    }
    @Override
    public List<Producer> findAll() {
        return new ArrayList<Producer>(categoryMap.values());
    }

    @Override
    public Producer findById(int id) {
        return categoryMap.get(id);
    }
}
