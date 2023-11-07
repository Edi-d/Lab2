package repository;

import domain.Identifiable;
import domain.Review;

import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T extends Identifiable> {
    List<T> objects = new ArrayList<>();
    public void add(T entity) {
        objects.add(entity);
    }
    public void update(T entity, T newEntity) {
        entity = newEntity;
    }
    public void deleteById(int id) {
        objects.removeIf(entity -> entity.getId() == id);
    }
    public List<T> getAll() {
        return new ArrayList<>(objects);
    }

}
