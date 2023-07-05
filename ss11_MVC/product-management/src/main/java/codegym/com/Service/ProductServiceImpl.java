package codegym.com.Service;

import codegym.com.Model.Product;
import codegym.com.Repository.ProductRepository;
import codegym.com.Repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
