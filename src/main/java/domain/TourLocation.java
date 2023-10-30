package domain;

public class TourLocation {
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

    public TourLocation(Tour tour, LocationMapping location, int order) {
        this.tour = tour;
        this.location = location;
        Order = order;
    }
}
