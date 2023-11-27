package repository;

import domain.Identifiable;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DatabaseRepository<ObjectType extends Identifiable> {
    private Connection connection;

    public DatabaseRepository(Connection connection) {
        this.connection = connection;
    }

    public abstract String getTableName();

    public void add(ObjectType entity) {
        String insertQuery = buildInsertQuery(entity);
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            setParameters(preparedStatement, entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void update(ObjectType entity, ObjectType newEntity) {
        // Implement the update logic using SQL UPDATE statement
        // Example: "UPDATE your_table_name SET column1 = ?, column2 = ? WHERE id = ?"
        // Don't forget to set the parameters in the PreparedStatement
    }

    public void deleteById(int id) {
        String deleteQuery = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public List<ObjectType> getAll() {
        List<ObjectType> resultList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + getTableName();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ObjectType entity = createFromResultSet(resultSet);
                resultList.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return resultList;
    }

    private String buildInsertQuery(ObjectType entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        StringBuilder queryBuilder = new StringBuilder("INSERT INTO " + getTableName() + " (");
        for (Field field : fields) {
            queryBuilder.append(field.getName()).append(", ");
        }
        queryBuilder.setLength(queryBuilder.length() - 2); // Remove the last comma and space
        queryBuilder.append(") VALUES (");
        for (Field field : fields) {
            queryBuilder.append("?, ");
        }
        queryBuilder.setLength(queryBuilder.length() - 2); // Remove the last comma and space
        queryBuilder.append(")");
        return queryBuilder.toString();
    }

    private void setParameters(PreparedStatement preparedStatement, ObjectType entity) throws SQLException {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {
                preparedStatement.setObject(i + 1, field.get(entity));
            } catch (IllegalAccessException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }
    }

    public abstract ObjectType createFromResultSet(ResultSet resultSet) throws SQLException;
}


