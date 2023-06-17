package com.library.libraryservice.client;

import com.library.libraryservice.dtos.BookDto;
import com.library.libraryservice.dtos.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "book-service", path = "/v1/book")
public interface BookServiceClient {
    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn);

    @GetMapping("/book/{id}")
    ResponseEntity<BookDto> getBookDetailById(@PathVariable UUID id);
}
