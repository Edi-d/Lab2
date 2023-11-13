package controller;
import DiscountStrategy.DiscountStrategy;
import DiscountStrategy.PercentageDiscount;
import DiscountStrategy.NoDiscount;
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
        DiscountStrategy discountCalculator = new NoDiscount();
        Tour tour;
        if ("Walking".equalsIgnoreCase(tourType)) {
            WalkingTourFactory walkingTourFactory = new WalkingTourFactory();
            tour =  walkingTourFactory.createTour(Id, name, description, price);
            discountCalculator = new PercentageDiscount();

        } else if ("Cycling".equalsIgnoreCase(tourType)) {
            CyclingTourFactory cyclingTourFactory = new CyclingTourFactory();
            tour = cyclingTourFactory.createTour(Id, name, description, price);

        } else {
            throw new IllegalArgumentException("Unknown tour type: " + tourType);
        }

        float discountPrice = tour.getPrice();
        discountCalculator.applyDiscount(discountPrice);
        return tour;
    }

}
