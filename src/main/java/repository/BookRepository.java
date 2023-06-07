//package repository;
//
//import entity.Book;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
package repository;

import config.MyConnection;
import entity.Book;
import entity.Writer;

import java.sql.*;

public class BookRepository {

    public void saveUser(Book users) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "insert into book( title, author, year_of_publish) values (?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, users.getTitle());
        preparedStatement.setString(2, users.getAuthor());
        preparedStatement.setInt(3, users.getYearPublished());
        preparedStatement.executeUpdate();
        connection.close();
    }

    public Book loadUser(int id) throws SQLException {
        String Title = "";
        String Author = "";
        int year = 0;
        int userId = 0;
        Connection connection = MyConnection.getConnection();
        String sql = "SELECT * FROM  users where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            userId = resultSet.getInt("user_id");
            Title = resultSet.getString("name");
            Author = resultSet.getString("last_name");
            year = resultSet.getInt("age");
        }
        Book users = new Book(userId, Title, Author, year);

        resultSet.close();
        preparedStatement.close();
        return users;
    }
    public void delete(Book book) {
        try {
            String sql = "DELETE FROM books WHERE title = ? AND author = ? AND year_published = ?";
            Connection connection = MyConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYearPublished());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



