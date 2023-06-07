package repository;

import config.MyConnection;
import entity.Writer;

import java.sql.*;

//import static jdk.internal.icu.lang.UCharacter.getAge;


public class AuthorRepository {
//    private Connection getConnection() throws SQLException {
//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        String username = "postgres";
//        String password = "1234";
//        return DriverManager.getConnection(url, username, password);
//    }

//    public void save(Writer writer) {
//        try (Connection connection = getConnection()) {
//            String sql = "INSERT INTO Writer (name, last_name, age, book) VALUES (?, ?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, writer.getName());
//            statement.setString(2, writer.getLastName());
//            statement.setInt(3, writer.getAge());
//            statement.setArray(4, connection.createArrayOf("varchar", writer.getBook()));
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
public void saveUser(Writer users) throws SQLException {
    Connection connection = MyConnection.getConnection();
    String sql = "insert into Writer( name, last_name, age, book) values (?,?,?,?) ";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, users.getName());
    preparedStatement.setString(2, users.getLastName());
    preparedStatement.setInt(3, users.getAge());
    preparedStatement.setArray(4, connection.createArrayOf("varchar", users.getBook()));
    preparedStatement.executeUpdate();
    connection.close();
}

//    public Writer load(int writerId) {
//        try (Connection connection = getConnection()) {
//            String sql = "SELECT id, name, last_name, age, book FROM Writer WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, writerId);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String lastName = resultSet.getString("last_name");
//                int age = resultSet.getInt("age");
//                String[] book = (String[]) resultSet.getArray("book").getArray();
//                return new Writer(id, name, lastName, age, book);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
public Writer loadUser(int id) throws SQLException {
    String Name = "";
    String last_name = "";
    int age = 0;
    Array book = null;
    int userId = 0;
    Connection connection = MyConnection.getConnection();
    String sql = "SELECT * FROM  users where id = ? ";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1, id);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
        userId = resultSet.getInt("id");
        Name = resultSet.getString("name");
        last_name = resultSet.getString("last_name");
        age = resultSet.getInt("age");
        book = resultSet.getArray("book");
    }
    Writer users = new Writer(userId, Name, last_name, age, book);

    resultSet.close();
    preparedStatement.close();
    return users;
}
}
