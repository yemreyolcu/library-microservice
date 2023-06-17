package com.library.libraryservice.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class BookIdDto {
    private UUID id;
    private String isbn;

    public BookIdDto(UUID id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }
}
