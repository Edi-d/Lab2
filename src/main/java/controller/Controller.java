package controller;
import DiscountStrategy.DiscountStrategy;
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

    public Controller(Repository<ObjectType> repository) {
        this.repository = repository;
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
    public Tour createTour(int Id, String name, String description, String tourType, float price) {
        DiscountStrategy discountCalculator = new DiscountStrategy();
        if ("Walking".equalsIgnoreCase(tourType)) {
            WalkingTourFactory walkingTourFactory = new WalkingTourFactory();
            WalkingTour tour =  walkingTourFactory.createTour(Id, name, description, price);
            float discountPrice = tour.getPrice();
            applyDiscount(discountPrice);
        } else if ("Cycling".equalsIgnoreCase(tourType)) {
            CyclingTourFactory cyclingTourFactory = new CyclingTourFactory();
            return cyclingTourFactory.createTour(Id, name, description, price);
        } else {
            throw new IllegalArgumentException("Unknown tour type: " + tourType);
        }
    }

}
