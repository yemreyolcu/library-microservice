package com.book.bookservice;

import com.book.bookservice.entities.Book;
import com.book.bookservice.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceApplication implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BookServiceApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // uuid, title, author, isbn, pressName, bookYear uuid auto generated
        Book book1 = new Book("The Lord of the Rings", "J. R. R. Tolkien", "978-0-618-57498-5", "Houghton Mifflin Harcourt", 1954);
        Book book2 = new Book("The Hobbit", "J. R. R. Tolkien", "978-0-618-57499-2", "Houghton Mifflin Harcourt", 1937);
        Book book3 = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", "978-0-7475-3269-6", "Bloomsbury", 1997);
        List<Book> books = bookRepository.saveAll(Arrays.asList(book1, book2, book3));
        System.out.println("Books saved: " + books.size());
    }
}
