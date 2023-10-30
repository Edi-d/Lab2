package repository;
import domain.Booking;
import java.util.ArrayList;
import java.util.List;
public class BookingRepository implements Repository<Booking> {
    private List<Booking> bookingList = new ArrayList<>();
    @Override
    public void create(Booking entity) {

    }

    @Override
    public void update(Booking entity) {

    }

    @Override
    public void delete(Booking entity) {

    }

    @Override
    public List<Booking> getAll() {
        return null;
    }
}