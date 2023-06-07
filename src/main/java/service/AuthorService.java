package service;

import entity.Writer;
import repository.AuthorRepository;

import java.sql.SQLException;


public class AuthorService {
    AuthorRepository authorRepository = new AuthorRepository();
    public void register(String name, String lastName, int age) throws SQLException {
        Writer author = new Writer(name, lastName, age, 0);
        authorRepository.saveUser(author);
    }
}
