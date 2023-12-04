package dbRepo;

import controller.CrudRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TourRepo {

    controller.CrudRepository crudRepository = new CrudRepository();

    public void addTour(Connection db, String name, String description, int locationid) throws SQLException {
        String addCustomerQuery = "INSERT INTO public.Tour (name, description, locationid) VALUES (?, ?, ?)";
        crudRepository.addObjectToDatabase(db, addCustomerQuery, name, description, locationid);
    }

    public void deleteTour(Connection db, int id) throws SQLException {
        String query = "DELETE FROM public.Tour WHERE id = ?";
        crudRepository.deleteFromDatabase(db, query, id);
    }

    public List<Object[]> getTour(Connection db, int id) throws SQLException {
        String query = "SELECT * FROM public.Tour WHERE id = ?";

        return crudRepository.getFromDatabase(db, query, id);
    }

}
