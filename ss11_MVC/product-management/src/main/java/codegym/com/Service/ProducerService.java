package codegym.com.Service;

import codegym.com.Model.Producer;
import codegym.com.Model.Product;

import java.util.List;

public interface ProducerService {
    Producer findById(int id);
    List<Producer> findAll();
}
