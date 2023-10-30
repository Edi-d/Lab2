package domain;

public class Booking {
    private int bookingId;
    private Guide guide;
    private Tour tour;
    private Payment payment;
    private String dateTime;

    public Booking(int bookingId, Guide guide, Tour tour, Payment payment, String dateTime) {
        this.bookingId = bookingId;
        this.guide = guide;
        this.tour = tour;
        this.payment = payment;
        this.dateTime = dateTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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