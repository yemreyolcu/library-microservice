package com.book.bookservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name ="press_name", nullable = false)
    private String pressName;

    @Column(name = "book_year", nullable = false)
    private int bookYear;

    public Book(String title, String author, String isbn, String pressName, int bookYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pressName = pressName;
        this.bookYear = bookYear;
    }
}