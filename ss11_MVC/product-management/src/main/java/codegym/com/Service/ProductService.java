package codegym.com.Service;

import codegym.com.Model.Product;
import codegym.com.Repository.ProductRepository;
import codegym.com.Repository.ProductRepositoryImpl;

import java.util.List;

public interface ProductService {

    void add(Product product);
    void update(Product product);
    void delete(Product product);
    Product findById(int id);
    List<Product> findAll();
}
