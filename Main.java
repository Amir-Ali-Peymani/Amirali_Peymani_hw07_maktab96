import entity.Writer;
import repository.AuthorRepository;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Writer
        Writer writer = new Writer(1, "John", "Doe", 30, new String[]{"Book1", "Book2"});

        // Create an instance of AuthorRepository
        AuthorRepository authorRepository = new AuthorRepository();

        // Call the save method to save the writer
        authorRepository.save(writer);

        // Call the load method to load a writer by ID
        Writer loadedWriter = authorRepository.load(1);

        // Print the loaded writer
        System.out.println(loadedWriter);
    }
}
