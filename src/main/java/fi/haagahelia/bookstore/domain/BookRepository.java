package fi.haagahelia.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(@Param("title") String title);
    List<Book> findByAuthor(@Param("author") String author);
    List<Book> findByIsbn(@Param("isbn") String isbn);
    List<Book> findByPublicationYear(@Param("publication_year") int publicationYear);
    List<Book> findByPrice(@Param("price") double price);
    List<Book> findByCategory(@Param("category") Category category);
    //http://localhost:8080/api/book/search/findByTitle?title=The%20Catcher%20in%20the%20Rye
    //http://localhost:8080/api/book/search/findByAuthor?author=J.D.%20Salinger
}