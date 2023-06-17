package com.library.libraryservice.services;

import com.library.libraryservice.client.BookServiceClient;
import com.library.libraryservice.dtos.BookDto;
import com.library.libraryservice.dtos.CreateBookDto;
import com.library.libraryservice.dtos.LibraryDto;
import com.library.libraryservice.entities.Library;
import com.library.libraryservice.exceptions.LibraryNotFoundException;
import com.library.libraryservice.repositories.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    public LibraryDto getAllBooksInLibraryById(String id) {
        System.out.println("Library : " + libraryRepository.findById(id));
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + id));

        return new LibraryDto(library.getId(),
                library.getBooks()
                        .stream()
                        .map(book -> bookServiceClient.getBookDetailById(book).getBody())
                        .collect(Collectors.toList()));
    }

    public LibraryDto createLibrary() {
        Library library = libraryRepository.save(new Library());
        List<BookDto> books = new ArrayList<>();
        return new LibraryDto(library.getId(), books);
    }

    public void addBookToLibrary(CreateBookDto request) {
        String bookId = Objects.requireNonNull(bookServiceClient.getBookByIsbn(request.getIsbn()).getBody()).getId();
        System.out.println("Book id : " + bookId);
        System.out.println("Create Library Request : " + libraryRepository.findById(request.getId()));
        Library library = libraryRepository.findById(request.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Library with id " + request.getId() + " not found"));
        library.getBooks().add(bookId);
        libraryRepository.save(library);
    }
}
