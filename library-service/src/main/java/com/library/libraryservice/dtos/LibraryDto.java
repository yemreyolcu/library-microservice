package com.library.libraryservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDto {
    private UUID id;
    private List<BookDto> userBooks = new ArrayList<>();
}
