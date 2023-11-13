package controller;
import domain.CyclingTour;
import domain.Identifiable;
import domain.Tour;
import domain.WalkingTour;
import factories.CyclingTourFactory;
import factories.TourFactory;
import factories.WalkingTourFactory;
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
    public <ObjectType> ObjectType createTour(int Id, String name, String description, String tourType) {
        if ("Walking".equalsIgnoreCase(tourType)) {
            WalkingTourFactory walkingTourFactory = new WalkingTourFactory();
            return (ObjectType) walkingTourFactory.createTour(Id, name, description);
        } else if ("Cycling".equalsIgnoreCase(tourType)) {
            CyclingTourFactory cyclingTourFactory = new CyclingTourFactory();
            return (ObjectType) cyclingTourFactory.createTour(Id, name, description);
        } else {
            throw new IllegalArgumentException("Unknown tour type: " + tourType);
        }
    }

}
