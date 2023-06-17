package com.book.bookservice.repositories;

import com.book.bookservice.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> findBookByIsbn(String isbn);
}