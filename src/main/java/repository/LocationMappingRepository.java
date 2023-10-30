package repository;

import domain.LocationMapping;

import java.util.ArrayList;
import java.util.List;

public class LocationMappingRepository implements Repository<LocationMapping>{
    private List <LocationMapping> location;

    public LocationMappingRepository(List<LocationMapping> location) {
        this.location = location;
    }

    @Override
    public void create(LocationMapping entity) {
        location.add(entity);
    }

    @Override
    public void update(LocationMapping entity) {
        // to implement
    }

    @Override
    public void delete(LocationMapping entity) {
        location.remove(entity);
    }

    @Override
    public List<LocationMapping> getAll() {
        return new ArrayList<>(location);
    }
}