package repository;

import domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Repository<Customer>{
    private List<Customer> customerList = new ArrayList<>();
    @Override
    public void save(Customer entity) {
        customerList.add(entity);
    }

    @Override
    public void remove(Customer entity) {
        customerList.remove(entity);
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }
}
