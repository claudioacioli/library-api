package com.bootcamp.library.api.controller;

import com.bootcamp.library.api.dto.FormBookDTO;
import com.bootcamp.library.api.dto.SimpleBookDTO;
import com.bootcamp.library.api.resource.BookResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/** This controller provides endpoints to handle Books
 *
 * @author claudio
 * create on 2021/09/26
 * @see BookResource
 */

@Controller
@RestController
@RequestMapping("/api/v1.0/books")
public class BookController {

    private static final BookResource bookResource = BookResource.getInstance();

    @GetMapping
    public Collection<SimpleBookDTO> readAll () {
        return bookResource.getAll();
    }

    @GetMapping("{isbn}")
    public SimpleBookDTO read (@PathVariable String isbn) {
        return bookResource.getBook(isbn);
    }

    @PostMapping
    public void create (@RequestBody @Valid FormBookDTO book) {
        bookResource.addBook(book);
    }

    @PutMapping
    public void  update (@RequestBody @Valid FormBookDTO book) {
        bookResource.updateBook(book);
    }

}
