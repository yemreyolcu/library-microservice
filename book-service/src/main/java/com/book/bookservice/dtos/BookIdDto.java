package com.book.bookservice.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class BookIdDto {
    private String id;
    private String isbn;

    public BookIdDto(String id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

}
