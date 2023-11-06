package domain;

public class CustomerBooking implements Identifiable{
    private int Id;
    private Customer customer;
    private Booking booking;

    public CustomerBooking(Customer customer, Booking booking) {
        this.customer = customer;
        this.booking = booking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customerId) {
        this.customer = customer;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking bookingId) {
        this.booking = booking;
    }

    @Override
    public int getId() {
        return Id;
    }
}
