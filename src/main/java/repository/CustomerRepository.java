package repository;

import domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Repository<Customer> {
    private List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    @Override
    public void create(Customer entity) {
        customers.add(entity);
    }

    @Override
    public void update(Customer entity) {
        // Implement update logic based on your requirements
    }

    @Override
    public void delete(Customer entity) {
        customers.remove(entity);
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customers);
    }
}
