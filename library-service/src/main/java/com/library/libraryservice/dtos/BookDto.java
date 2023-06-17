package com.library.libraryservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


}
