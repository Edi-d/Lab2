package repository;

import java.sql.*;

public class CustomerDatabaseRepository {

//    private void viewCustomer() throws SQLException {
//        connect();
//        String query = "SELECT * FROM Customers";
//        try (Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(query)) {
//            while (resultSet.next()) {
//                int flightId = resultSet.getInt("flightId");
//                String airline = resultSet.getString("airline");
//                String departureTime = resultSet.getString("departureTime");
//                String arrivalTime = resultSet.getString("arrivalTime");
//
//                System.out.println("ID: " + flightId + ", Airline: " + airline + ", departureTime: " + departureTime + ", arrivalTime: " + arrivalTime);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void addCustomer(Connection db, String firstName, String lastName, int age, String email) throws SQLException {
        String query = "INSERT INTO public.Customer (firstName, lastName, age, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, email);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(Connection db, int id) throws SQLException {
        String query = "DELETE FROM Flights WHERE flightId = ?";
        try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
