package controller;
import domain.Identifiable;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class Controller<ObjectType> {
    private  Repository<ObjectType> repository;

    public Controller(Repository<ObjectType> repository) {
        this.repository = repository;
    }

    public void add(ObjectType entity) {
        repository.add(entity);
    }

    public void update(ObjectType entity) {
        repository.update(entity);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }

    public List<ObjectType> getAll() {
        return repository.getAll();
    }
}
