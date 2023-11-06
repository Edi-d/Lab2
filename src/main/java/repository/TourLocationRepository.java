package repository;

import domain.TourLocation;

import java.util.ArrayList;
import java.util.List;

public class TourLocationRepository implements Repository<TourLocation>{
    private List <TourLocation> tourLocation;

    public TourLocationRepository(List<TourLocation> tourLocation) {
        this.tourLocation = tourLocation;
    }

    @Override
    public void add(TourLocation entity) {
        tourLocation.add(entity);
    }

    @Override
    public void update(TourLocation entity) {
    }

    @Override
    public void deleteById(int id) {
        tourLocation.removeIf(tourLocation -> tourLocation.getId() == id);
    }

    @Override
    public List<TourLocation> getAll() {
        return new ArrayList<>(tourLocation);
    }
}
