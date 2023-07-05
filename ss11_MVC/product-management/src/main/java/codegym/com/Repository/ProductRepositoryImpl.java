package codegym.com.Repository;

import codegym.com.Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository{
   private static Map<Integer, Product> products;
   static {
       products = new HashMap<>();
       ProducerRepository producerRepository = new ProducerRepositoryImpl();
       products.put(1,new Product(1,"Áo polo",20000,"100%",producerRepository.findById(1)));
       products.put(2,new Product(2,"Đồng Hồ Casio MTP-V30000",50000,"100%",producerRepository.findById(1)));
       products.put(3,new Product(3,"Tay Cầm chơi game PS4",100000,"100%",producerRepository.findById(3)));
       products.put(4,new Product(4,"Loa bluetooth đồng hồ E5",32000,"100%",producerRepository.findById(3)));
       products.put(5,new Product(5,"Xit thơm Body",10000,"100%",producerRepository.findById(4)));
       products.put(6,new Product(6,"Iphone 14 pro max",520000,"100%",producerRepository.findById(5)));

   }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void add(Product product) {
            products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update( Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void delete(Product product) {
       products.remove(product.getId());
    }


}
