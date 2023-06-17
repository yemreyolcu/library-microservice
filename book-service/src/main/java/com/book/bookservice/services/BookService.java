package com.book.bookservice.services;

import com.book.bookservice.dtos.BookDto;
import com.book.bookservice.dtos.BookIdDto;
import com.book.bookservice.entities.Book;
import com.book.bookservice.exceptions.BookNotFoundException;
import com.book.bookservice.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookDto::new)
                .toList();
    }

    public BookIdDto getBookByIsbn(String isbn) {
        Optional<Book> book = bookRepository.findBookByIsbn(isbn);
        return book.map(value -> new BookIdDto(value.getId(), value.getIsbn())).orElseThrow(
                () -> new BookNotFoundException("Book with isbn " + isbn + " not found")
        );
    }

    public BookDto getBookDetailById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(BookDto::new).orElseThrow(
                () -> new BookNotFoundException("Book with id " + id + " not found")
        );
    }

}
