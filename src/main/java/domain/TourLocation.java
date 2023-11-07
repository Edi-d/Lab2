package domain;

public class TourLocation implements Identifiable {
    private int Id;
    private Tour tour;
    private LocationMapping location;
    private int Order;

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public LocationMapping getLocation() {
        return location;
    }

    public void setLocation(LocationMapping location) {
        this.location = location;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int order) {
        Order = order;
    }

    public TourLocation(int Id, Tour tour, LocationMapping location, int order) {
        this.Id = Id;
        this.tour = tour;
        this.location = location;
        Order = order;
    }

    @Override
    public int getId() {
        return Id;
    }
}
