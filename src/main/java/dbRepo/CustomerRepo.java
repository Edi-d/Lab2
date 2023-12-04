package dbRepo;

import java.sql.*;
import java.util.List;

import controller.CrudRepository;
public class CustomerRepo {
    controller.CrudRepository crudRepository = new CrudRepository();

    public void addCustomer(Connection db, int id, String firstName, String lastName, int age, String email) throws SQLException {
        String addCustomerQuery = "INSERT INTO public.Customer (id, firstName, lastName, age, email) VALUES (?, ?, ?, ?, ?)";
        crudRepository.addObjectToDatabase(db, addCustomerQuery, id, firstName, lastName, age, email);
    }

    public void deleteCustomer(Connection db, int id) throws SQLException {
        String query = "DELETE FROM public.Customer WHERE id = ?";
        crudRepository.deleteFromDatabase(db, query, id);
    }

    public List<Object[]> getCustomer(Connection db, int id) throws SQLException {
        String query = "SELECT * FROM public.Customer WHERE id = ?";

        return crudRepository.getFromDatabase(db, query, id);
    }
}
