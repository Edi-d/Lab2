package repository;

import domain.Guide;

import java.util.ArrayList;
import java.util.List;

public class GuideRepository implements Repository<Guide>{
    private List <Guide> guides;

    public GuideRepository(List<Guide> guides) {
        this.guides = guides;
    }

    @Override
    public void add(Guide entity) {
        guides.add(entity);
    }

    @Override
    public void update(Guide entity) {
    }

    @Override
    public void deleteById(int id) {
        guides.removeIf(guides -> guides.getId() == id);
    }

    @Override
    public List<Guide> getAll() {
        return new ArrayList<>(guides);
    }
}