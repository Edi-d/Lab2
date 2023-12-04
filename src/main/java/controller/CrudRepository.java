package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudRepository {

    public void addObjectToDatabase(Connection db, String query, Object... values) throws SQLException {
        try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromDatabase(Connection db, String query, Object... values) throws SQLException {
        try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Object[]> getFromDatabase(Connection db, String query, Object... values) throws SQLException {
        List<Object[]> resultList = new ArrayList<>();

        try (PreparedStatement preparedStatement = db.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int columnCount = resultSet.getMetaData().getColumnCount();
                    Object[] row = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = resultSet.getObject(i + 1);
                    }
                    resultList.add(row);
                }
                System.out.println(resultList);
                System.out.println("list");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception according to your application's requirements
            throw e;
        }

        return resultList;
    }


}