package codegym.com.service;

import codegym.com.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService{
    private static Map<Integer,Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1,new Customer(1,"John","john@gmail.com","HaNoi"));
        customers.put(2,new Customer(2,"Bill","bill@gmail.com","Da Nang"));
        customers.put(3,new Customer(3,"Alex","alex@gmail.com","Sai Goi"));
        customers.put(4,new Customer(4,"Adam","adam@gmail.com","Quang Nam"));
        customers.put(5,new Customer(5,"Sophia","sophia@gmail.com","Binh Dinh"));
        customers.put(6,new Customer(6,"Rose","rose@gmail.com","Gia Lai"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
