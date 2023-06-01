package repository;

import entity.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepository {
    private Connection connection;

    public BookRepository() {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/your_database", "your_username", "your_password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Book book) {
        try {
            String sql = "INSERT INTO books (title, author, year_published) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYearPublished());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book load(String title, String author, int yearPublished) {
        try {
            String sql = "SELECT * FROM books WHERE title = ? AND author = ? AND year_published = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, yearPublished);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String loadedTitle = resultSet.getString("title");
                String loadedAuthor = resultSet.getString("author");
                int loadedYearPublished = resultSet.getInt("year_published");
                return new Book(loadedTitle, loadedAuthor, loadedYearPublished);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Book book) {
        try {
            String sql = "DELETE FROM books WHERE title = ? AND author = ? AND year_published = ?";
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

