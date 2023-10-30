package controller;
import domain.Identifiable;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class Controller<ObjectType /*extends Identifiable*/ > {

    // Implement object type identifiable, adica getid general ca sa evit
    // chestia aia din remove cu customerid
    // trb lucrat cumva cu un id
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

//        List<ObjectType> entities = repository.getAll();
//        List<ObjectType> entitiesToRemove = new ArrayList<>();
//        for (ObjectType entity : entities) {
//            if (entity.getId() == id) {
//                entitiesToRemove.add(entity);
//            }
//        }
//        for ( ObjectType entity : entitiesToRemove) {
//            repository.delete(entity);
//        }
////            entity.get_id();
////            if (entity instanceof Customer) {
////                Customer customer = (Customer) entity;
////                if (customer.getId() == id) {
////                    repository.delete(entity);
////                    break;
////                }
////            }
        }

    public List<ObjectType> getAll() {
        return repository.getAll();
    }
}
