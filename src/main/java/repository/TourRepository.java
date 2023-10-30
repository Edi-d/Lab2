package repository;

import domain.Tour;

import java.util.ArrayList;
import java.util.List;

public class TourRepository implements Repository<Tour>{

    private List <Tour> tour;

    public TourRepository(List<Tour> payments) {
        this.tour = payments;
    }

    @Override
    public void add(Tour entity) {
        tour.add(entity);
    }

    @Override
    public void update(Tour entity) {
    }

    @Override
    public void delete(Tour entity) {
        tour.remove(entity);
    }

    @Override
    public List<Tour> getAll() {
        return new ArrayList<>(tour);
    }
}
