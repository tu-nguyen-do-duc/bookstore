package fi.haagahelia.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			log.info("Hibernate: insert into book (title, author, publication_year, isbn, price) values (?, ?, ?, ?, ?)");
			repository.save(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488", 1951, 10.99));
			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", 1960, 12.99));
			repository.save(new Book("1984", "George Orwell", "9780451524935", 1949, 15.99));
			repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925, 14.99));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
