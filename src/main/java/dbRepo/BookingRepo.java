package dbRepo;

import controller.CrudRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookingRepo {

    controller.CrudRepository crudRepository = new CrudRepository();

    public void addBooking(Connection db, int guideid, int tourid, int paymentid, String date, int customerid) throws SQLException {
        String addCustomerQuery = "INSERT INTO public.Booking (guideid, tourid, paymentid, date, customerid) VALUES (?, ?, ?, ?, ?)";
        crudRepository.addObjectToDatabase(db, addCustomerQuery, guideid, tourid, paymentid, date, customerid);
    }

    public void deleteBooking(Connection db, int id) throws SQLException {
        String query = "DELETE FROM public.Booking WHERE id = ?";
        crudRepository.deleteFromDatabase(db, query, id);
    }

    public List<Object[]> getBooking(Connection db, int id) throws SQLException {
        String query = "SELECT * FROM public.Booking WHERE id = ?";

        return crudRepository.getFromDatabase(db, query, id);
    }

}
