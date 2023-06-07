package service;

import entity.Book;
import repository.BookRepository;

import java.sql.SQLException;

public class BookService {
    BookRepository bookRepository = new BookRepository();

    public void addBook(String title, String author, int yearPublished) throws SQLException {
        int userId = 0;
        Book book = new Book(userId, title, author, yearPublished);

        bookRepository.saveUser(book);
    }
}
