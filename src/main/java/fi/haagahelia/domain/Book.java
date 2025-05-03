package fi.haagahelia.domain;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private double price;

    public Book() {
    }

    public Book(String title, String author, int publicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book id=" + id + 
            ", title=" + title +
            ", author=" + author +
            ", publicationYear=" + publicationYear +
            ", isbn=" + isbn +
            ", price=" + price;
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            // save a couple of books
            repository.save(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "9780316769488", 10.99));
            repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780061120084", 12.99));
            repository.save(new Book("1984", "George Orwell", 1949, "9780451524935", 15.99));
            repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565", 14.99));
        };
    }
    
}
