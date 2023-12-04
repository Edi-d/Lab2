package dbRepo;

import controller.CrudRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LocationRept {

    controller.CrudRepository crudRepository = new CrudRepository();

    public void addLocation(Connection db, String name, String description, String location) throws SQLException {
        String addCustomerQuery = "INSERT INTO public.Location (name, description, location) VALUES (?, ?, ?)";
        crudRepository.addObjectToDatabase(db, addCustomerQuery, name, description, location);
    }

    public void deleteLocation(Connection db, int id) throws SQLException {
        String query = "DELETE FROM public.Tour WHERE id = ?";
        crudRepository.deleteFromDatabase(db, query, id);
    }

    public List<Object[]> getLocation(Connection db, int id) throws SQLException {
        String query = "SELECT * FROM public.Tour WHERE id = ?";

        return crudRepository.getFromDatabase(db, query, id);
    }

}
