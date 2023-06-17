package com.library.libraryservice.client;

import com.library.libraryservice.dtos.BookDto;
import com.library.libraryservice.dtos.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "book-service", path = "/v1/book")
public interface BookServiceClient {
    // Logger logger = Logger.getLogger(BookServiceClient.class.getName());
    @GetMapping("/isbn/{isbn}")
    // @CircuitBreaker(name = "getBookByIsbnCircuitBreaker", fallbackMethod = "getBookFallBack")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn);

    /* default ResponseEntity<BookIdDto> getBookFallBack(String isbn, Exception e) {
        logger.info("getBookFallBack method called book not found for isbn: " + isbn);
        return ResponseEntity.ok(new BookDto (new BookIdDto("default-id", "default-isbn")));
    } */

    @GetMapping("/book/{id}")
    ResponseEntity<BookDto> getBookDetailById(@PathVariable String id);
}
