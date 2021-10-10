package com.bootcamp.library.api.controller;

import com.bootcamp.library.api.dto.FormBookDTO;
import com.bootcamp.library.api.dto.SimpleBookDTO;
import com.bootcamp.library.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;

/** This controller provides endpoints to handle Books
 *
 * @author claudio
 * create on 2021/09/26
 * @see BookService
 */

@Controller
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Collection<SimpleBookDTO> readAll () {
        return bookService.getAll();
    }

    @GetMapping("/{isbn}")
    public SimpleBookDTO read (@PathVariable String isbn) {
        return bookService.getBook(isbn);
    }

    @PostMapping
    public ResponseEntity<FormBookDTO> create (@RequestBody @Valid FormBookDTO book, UriComponentsBuilder uriBuilder) {
        bookService.addBook(book);
        URI uri = uriBuilder.path("/books/{isbn}").buildAndExpand(book.getIsbn()).toUri();
        return ResponseEntity.created(uri).body(book);
    }

    @PutMapping
    public void  update (@RequestBody @Valid FormBookDTO book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/{isbn}")
    public void delete (@PathVariable String isbn) {
        bookService.deleteBook(isbn);
    }
}
