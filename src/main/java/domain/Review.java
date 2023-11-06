package domain;

public class Review {
    private int Id;
    private Customer customer;
    private Tour tour;
    private int rating;
    private String comment;
    public Review(int reviewId, Customer customer, Tour tour, int rating, String comment){
        this.Id = reviewId;
        this.customer = customer;
        this.tour = tour;
        this.rating = rating;
        this.comment = comment;
    }

    public int getId() {
        return Id;
    }

    public void setId(int reviewId) {
        this.Id = reviewId;
    }

    public Customer getCustomerId() {
        return customer;
    }

    public void setCustomerId(Customer customerId) {
        this.customer = customerId;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
