package repository;

import entity.Writer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthorRepository {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "1234";
        return DriverManager.getConnection(url, username, password);
    }

    public void save(Writer writer) {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO Writer (name, last_name, age, book) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, writer.getName());
            statement.setString(2, writer.getLastName());
            statement.setInt(3, writer.getAge());
            statement.setArray(4, connection.createArrayOf("varchar", writer.getBookNames()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Writer load(int writerId) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT name, last_name, age, book FROM Writer WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, writerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String[] book = (String[]) resultSet.getArray("book").getArray();
                return new Writer(name, lastName, age, book.length);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
