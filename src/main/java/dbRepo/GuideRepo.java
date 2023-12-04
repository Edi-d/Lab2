package dbRepo;

import controller.CrudRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GuideRepo {

    controller.CrudRepository crudRepository = new CrudRepository();

    public void addGuide(Connection db, int id, String firstName, String lastName, int age, String email) throws SQLException {
        String addCustomerQuery = "INSERT INTO public.Guide (id, firstName, lastName, age, email) VALUES (?, ?, ?, ?, ?)";
        crudRepository.addObjectToDatabase(db, addCustomerQuery, id, firstName, lastName, age, email);
    }

    public void deleteGuide(Connection db, int id) throws SQLException {
        String query = "DELETE FROM public.Guide WHERE id = ?";
        crudRepository.deleteFromDatabase(db, query, id);
    }

    public List<Object[]> getGuide(Connection db, int id) throws SQLException {
        String query = "SELECT * FROM public.Guide WHERE id = ?";

        return crudRepository.getFromDatabase(db, query, id);
    }

}