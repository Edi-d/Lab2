package dbRepo;

import controller.CrudRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PaymentRepo {

    controller.CrudRepository crudRepository = new CrudRepository();

    public void addPayment(Connection db, int id, int price, String method) throws SQLException {
        String addCustomerQuery = "INSERT INTO public.Payment (id, price, method) VALUES (?, ?, ?)";
        crudRepository.addObjectToDatabase(db, addCustomerQuery, id, price, method);
    }

    public void deletePayment(Connection db, int id) throws SQLException {
        String query = "DELETE FROM public.Payment WHERE id = ?";
        crudRepository.deleteFromDatabase(db, query, id);
    }

    public List<Object[]> getPayment(Connection db, int id) throws SQLException {
        String query = "SELECT * FROM public.Payment WHERE id = ?";

        return crudRepository.getFromDatabase(db, query, id);
    }

}
