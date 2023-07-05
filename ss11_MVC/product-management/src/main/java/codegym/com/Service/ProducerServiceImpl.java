package codegym.com.Service;

import codegym.com.Model.Producer;
import codegym.com.Repository.ProducerRepository;
import codegym.com.Repository.ProducerRepositoryImpl;

import java.util.List;

public class ProducerServiceImpl implements ProducerService{
    private ProducerRepository producerRepository = new ProducerRepositoryImpl();
    @Override
    public Producer findById(int id) {
        return producerRepository.findById(id);
    }

    @Override
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }
}
