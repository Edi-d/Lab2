package controller;
import java.util.ArrayList;
import domain.Customer;
import repository.Repository;

import java.util.List;

public class CustomerController {
    private final Repository<Customer> customerRepository;

    public CustomerController(Repository<Customer> customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        customerRepository.create(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.update(customer);
    }

    public void removeCustomer(int CustomerId) {
        List<Customer> customers = customerRepository.getAll();
        List<Customer> customersToRemove = new ArrayList<>();
        for (Customer Customer : customers) {
            if (Customer.getcustomerId() == CustomerId) {
                customersToRemove.add(Customer);
            }
        }
        for (Customer Customer : customersToRemove) {
            customerRepository.delete(Customer);
        }
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAll();
    }

//    public Customer getCustomerByUserId(int userId) {
//        if (customerRepository instanceof CustomerRepository) {
//            return ((CustomerRepository) customerRepository).getByUserId(userId);
//        }
//        return null;
//    }
}
