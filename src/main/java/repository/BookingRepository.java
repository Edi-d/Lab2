package repository;
import domain.Booking;
import domain.Guide;

import java.util.ArrayList;
import java.util.List;
public class BookingRepository implements Repository<Booking> {
    private List<Booking> booking;

    public BookingRepository() {
        this.booking = booking;
    }

    @Override
    public void create(Booking entity) {
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