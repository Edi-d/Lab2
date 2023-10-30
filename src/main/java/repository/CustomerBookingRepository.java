package repository;
import domain.Booking;
import domain.CustomerBooking;

import java.util.ArrayList;
import java.util.List;

public class CustomerBookingRepository implements Repository<CustomerBooking> {
    private List<CustomerBooking> customerBookings;

    public CustomerBookingRepository() {
        this.customerBookings = new ArrayList<>();
    }

    @Override
    public void add(CustomerBooking entity) {
        customerBookings.add(entity);
    }

    @Override
    public void update(CustomerBooking entity) {

    }

//    public void updateCustomerBooking(int customerId, Booking booking) {
//        for (CustomerBooking customerBooking : customerBookings) {
//            if (customerBooking.getCustomer().getUserId() == customerId) {
//                customerBooking.setBooking(booking);
//                return;
//            }
//        }
//    }

    @Override
    public void delete(CustomerBooking entity) {
        customerBookings.remove(entity);
    }

    @Override
    public List<CustomerBooking> getAll() {
        return new ArrayList<>(customerBookings);
    }
}
