package repository;
import domain.Identifiable;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository<ObjectType extends Identifiable> {
    List<ObjectType> objects = new ArrayList<>();
    public void add(ObjectType entity) {
        objects.add(entity);
    }
    public void update(ObjectType entity, ObjectType newEntity) {
        entity = newEntity;
    }
    public void deleteById(int id) {
        objects.removeIf(entity -> entity.getId() == id);
    }
    public List<ObjectType> getAll() {
        return new ArrayList<>(objects);
    }

}
