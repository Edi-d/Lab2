package repository;
import domain.Booking;
import java.util.ArrayList;
import java.util.List;
public class BookingRepository implements Repository<Booking> {
    private List<Booking> bookingList = new ArrayList<>();
    @Override
    public void save(Booking entity) {
        bookingList.add(entity);
    }
    @Override
    public void remove(Booking entity) {

        bookingList.remove(entity);
    }
    @Override
    public List<Booking> getAll() {

        return bookingList;
    }
}