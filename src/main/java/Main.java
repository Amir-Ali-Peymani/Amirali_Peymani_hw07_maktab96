import service.AuthorService;
import service.BookService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AuthorService authorService = new AuthorService();
        BookService bookService = new BookService();
//        authorService.register("John", "Doe", 30);
        bookService.addBook("Book Title", "John Doe", 2023);
    }
}
