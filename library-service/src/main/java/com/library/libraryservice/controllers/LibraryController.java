package com.library.libraryservice.controllers;

import com.library.libraryservice.dtos.CreateBookDto;
import com.library.libraryservice.dtos.LibraryDto;
import com.library.libraryservice.services.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable UUID id) {
        Optional<LibraryDto> library = Optional.ofNullable(libraryService.getAllBooksInLibraryById(id));
        return library.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary() {
        return new ResponseEntity<>(libraryService.createLibrary(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody CreateBookDto request) {
        libraryService.addBookToLibrary(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
