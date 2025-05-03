package fi.haagahelia.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByPublicationYear(int publicationYear);
    List<Book> findByIsbn(String isbn);
    List<Book> findByPrice(double price);


}