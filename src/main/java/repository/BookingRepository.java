package repository;
import domain.Booking;

import java.util.ArrayList;
import java.util.List;
public class BookingRepository implements Repository<Booking> {
    private List<Booking> booking;

    public BookingRepository() {
        this.booking = new ArrayList<>();
    }

    @Override
    public void add(Booking entity) {
        booking.add(entity);
    }

    @Override
    public void update(Booking entity) {
    }

    @Override
    public void delete(Booking entity) {
        booking.remove(entity);
    }

    @Override
    public List<Booking> getAll() {
        return new ArrayList<>(booking);
    }
}