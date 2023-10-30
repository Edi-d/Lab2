package controller;

import domain.Customer;
import repository.Repository;

import java.util.List;

public class Controller<ObjectType> {
    private  Repository<ObjectType> repository;

    public Controller(Repository<ObjectType> repository) {
        this.repository = repository;
    }

    public void create(ObjectType entity) {
        repository.create(entity);
    }

    public void update(ObjectType entity) {
        repository.update(entity);
    }

    public void remove(int id) {
        List<ObjectType> entities = repository.getAll();
        for (ObjectType entity : entities) {
            if (entity instanceof Customer) {
                Customer customer = (Customer) entity;
                if (customer.getcustomerId() == id) {
                    repository.delete(entity);
                    break;
                }
            }
        }
    }

    public List<ObjectType> getAll() {
        return repository.getAll();
    }
}
