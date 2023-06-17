package com.book.bookservice.dtos;

import com.book.bookservice.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private BookIdDto id;
    private String title;
    private String author;
    private String isbn;
    private String pressName;
    private int bookYear;

    public BookDto(Book book) {
        this.id = new BookIdDto(book.getId(), book.getIsbn());
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.pressName = book.getPressName();
        this.bookYear = book.getBookYear();
    }
}
