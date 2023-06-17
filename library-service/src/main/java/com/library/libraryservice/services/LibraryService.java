package com.library.libraryservice.services;

import com.library.libraryservice.client.BookServiceClient;
import com.library.libraryservice.dtos.BookDto;
import com.library.libraryservice.dtos.CreateBookDto;
import com.library.libraryservice.dtos.LibraryDto;
import com.library.libraryservice.entities.Library;
import com.library.libraryservice.exceptions.LibraryNotFoundException;
import com.library.libraryservice.repositories.LibraryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    public LibraryDto getAllBooksInLibraryById(UUID id) {
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library with id " + id + " not found"));
        System.out.println("Library : " + library) ;
        List<BookDto> books = library.getBooks().stream().map(bookId -> {
            ResponseEntity<BookDto> book = bookServiceClient.getBookDetailById(UUID.fromString(bookId));
            return book.getBody();
        }).collect(Collectors.toList());
        LibraryDto libraryDto = new LibraryDto(library.getId(), books);
        System.out.println("LibraryDto : " + libraryDto);
        return libraryDto;
    }

    public LibraryDto createLibrary() {
        Library library = libraryRepository.save(new Library());
        List<BookDto> books = new ArrayList<>();
        return new LibraryDto(library.getId(), books);
    }

    public void addBookToLibrary(CreateBookDto request) {
        UUID bookId = Objects.requireNonNull(bookServiceClient.getBookByIsbn(request.getIsbn()).getBody()).getId();
        Library library = libraryRepository.findById(request.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Library with id " + request.getId() + " not found"));
        library.getBooks().add(bookId.toString());
        libraryRepository.save(library);
    }
}
