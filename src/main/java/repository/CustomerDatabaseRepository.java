
package repository;
import database.Connect_db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDatabaseRepository {
    private static Connect_db connection;
    private void connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/virtual_guide";
        String user = "admin";
        String password = "S3cret";
    }

    private void viewCustomer() throws SQLException {
        connect();
        String query = "SELECT * FROM Customer";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int Id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");


                System.out.println("ID: " + Id + ", FirstName: " + firstName + ", Last Name: " + lastName + ", age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addCustomer(int flightId, String airline, String departureTime, String arrivalTime) throws SQLException {
        connect();
        String query = "INSERT INTO Flight (flightId, airline, departureTime, arrivalTime) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, flightId);
            preparedStatement.setString(2, airline);
            preparedStatement.setString(3, departureTime);
            preparedStatement.setString(4, arrivalTime);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(int flightId) throws SQLException {
        connect();
        String query = "DELETE FROM Flights WHERE flightId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, flightId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}