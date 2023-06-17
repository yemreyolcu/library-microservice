package com.library.libraryservice.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class BookIdDto {
    private String id;
    private String isbn;

    public BookIdDto(String id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }
}
