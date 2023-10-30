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
    public void create(TourLocation entity) {
        tourLocation.add(entity);
    }

    @Override
    public void update(TourLocation entity) {
    }

    @Override
    public void delete(TourLocation entity) {
        tourLocation.remove(entity);
    }

    @Override
    public List<TourLocation> getAll() {
        return new ArrayList<>(tourLocation);
    }
}
