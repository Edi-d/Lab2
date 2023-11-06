package repository;

import domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Repository<Customer> {
    private List <Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    @Override
    public void add(Customer entity) {
        customers.add(entity);
    }

    @Override
    public void update(Customer entity) {
    }

    @Override
    public void deleteById(int id) {
        customers.removeIf(customers -> customers.getId() == id);
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customers);
    }
}