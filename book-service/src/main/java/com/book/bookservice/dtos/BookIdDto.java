package com.book.bookservice.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class BookIdDto {
    private UUID id;
    private String isbn;

    public BookIdDto(UUID id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

}
