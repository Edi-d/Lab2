package repository;

import java.util.List;

public interface Repository<T> {
    void create(T entity); // Equivalent to the "save" operation in CRUD
    void update(T entity); // Equivalent to the "update" operation in CRUD
    void delete(T entity); // Equivalent to the "remove" operation in CRUD
    List<T> getAll();      // Equivalent to the "read" operation in CRUD
}
