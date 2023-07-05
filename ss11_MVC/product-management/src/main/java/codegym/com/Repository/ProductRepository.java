package codegym.com.Repository;

import codegym.com.Model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void add(Product product);
    Product findById(int id);
    void update( Product product);
    void delete(Product product);
//    List<Product> searchName(String string);
}
