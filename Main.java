import entity.Writer;
import repository.AuthorRepository;

public class Main {
    public static void main(String[] args) {
       
        Writer writer = new Writer(1, "John", "Doe", 30, new String[]{"Book1", "Book2"});

        
        AuthorRepository authorRepository = new AuthorRepository();

        
        authorRepository.save(writer);

        
        Writer loadedWriter = authorRepository.load(1);

        
        System.out.println(loadedWriter);
    }
}
