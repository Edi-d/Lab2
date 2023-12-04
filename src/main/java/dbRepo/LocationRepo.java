package dbRepo;

import controller.CrudRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LocationRepo {

    controller.CrudRepository crudRepository = new CrudRepository();

    public void addLocation(Connection db, int id, String name, String description, String location) throws SQLException {
        String addCustomerQuery = "INSERT INTO public.Location (id, name, description, location) VALUES (?, ?, ?, ?)";
        crudRepository.addObjectToDatabase(db, addCustomerQuery, id, name, description, location);
    }

    public void deleteLocation(Connection db, int id) throws SQLException {
        String query = "DELETE FROM public.Location WHERE id = ?";
        crudRepository.deleteFromDatabase(db, query, id);
    }

    public List<Object[]> getLocation(Connection db, int id) throws SQLException {
        String query = "SELECT * FROM public.Location WHERE id = ?";

        return crudRepository.getFromDatabase(db, query, id);
    }

}
