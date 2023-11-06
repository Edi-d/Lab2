package domain;

public class Booking implements Identifiable {
    private int Id;
    private Guide guide;
    private Tour tour;
    private Payment payment;
    private String dateTime;

    public Booking(int Id, Guide guide, Tour tour, Payment payment, String dateTime) {
        this.Id = Id;
        this.guide = guide;
        this.tour = tour;
        this.payment = payment;
        this.dateTime = dateTime;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}