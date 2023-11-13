package controller;
import domain.CyclingTour;
import domain.Identifiable;
import factories.TourFactory;
import repository.Repository;

import java.util.List;

public class Controller<ObjectType extends Identifiable> {
    private Repository<ObjectType> repository;
    private TourFactory tourFactory;

    public Controller(Repository<ObjectType> repository, TourFactory tourFactory) {
        this.repository = repository;
        this.tourFactory = tourFactory;
    }

    public void add(ObjectType entity) {
        repository.add(entity);
    }

    public void update(ObjectType entity, ObjectType newEntity) {
        repository.update(entity, newEntity);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }

    public List<ObjectType> getAll() {
        return repository.getAll();
    }
    public ObjectType createTour(int Id, String name, String description, String tourType) {
        // Logic to determine which factory to use based on tourType
        if ("Walking".equalsIgnoreCase(tourType)) {
            return WalkingTourFactory.createTour(Id, name, description);
        } else if ("Cycling".equalsIgnoreCase(tourType)) {
            return (CyclingTour) tourFactory.createTour(Id, name, description);
        } else {
            // Handle unknown tour type or provide a default behavior
            throw new IllegalArgumentException("Unknown tour type: " + tourType);
        }
    }
}
