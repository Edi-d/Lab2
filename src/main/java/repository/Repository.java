package repository;

import java.util.List;

public interface Repository<T> {
    void add(T entity); // Equivalent to the "save" operation in CRUD
    void update(T entity); // Equivalent to the "update" operation in CRUD
    void deleteById(int id);
    List<T> getAll();      // Equivalent to the "read" operation in CRUD

}
