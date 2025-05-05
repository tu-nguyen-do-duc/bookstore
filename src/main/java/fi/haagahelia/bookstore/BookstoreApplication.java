package fi.haagahelia.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Hibernate: insert into book (title, author, publication_year, isbn, price, category) values (?, ?, ?, ?, ?, ?)");

			Category category1 = new Category("Fiction");
			Category category2 = new Category("Non-Fiction");
			crepository.save(category1);
			crepository.save(category2);

			repository.save(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488", 1951, 10.99, category1));
			repository.save(new Book("Interstellar", "Christopher Nolan", "9781234567890", 2014, 19.99, category2));
			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", 1960, 12.99, category1));
			repository.save(new Book("The Martian", "Andy Weir", "9780553418026", 2011, 14.99, category2));
			repository.save(new Book("1984", "George Orwell", "9780451524935", 1949, 15.99, category1));
			repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925, 14.99, category1));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
