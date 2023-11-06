package repository;

import domain.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepository implements Repository <Review>{
    private List <Review> reviews;

    public ReviewRepository(List<Review> payments) {
        this.reviews = payments;
    }

    @Override
    public void add(Review entity) {
        reviews.add(entity);
    }

    @Override
    public void update(Review entity) {
    }

    @Override
    public void deleteById(int id) {
        reviews.removeIf(reviews -> reviews.getId() == id);
    }

    @Override
    public List<Review> getAll() {
        return new ArrayList<>(reviews);
    }
}
