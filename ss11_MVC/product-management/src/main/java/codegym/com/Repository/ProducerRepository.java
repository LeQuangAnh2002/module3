package codegym.com.Repository;

import codegym.com.Model.Producer;

import java.util.List;

public interface ProducerRepository {
    List<Producer> findAll();
    Producer findById(int id);
}
