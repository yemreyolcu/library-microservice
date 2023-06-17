package com.book.bookservice.repositories;

import com.book.bookservice.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findBookByIsbn(String isbn);
}