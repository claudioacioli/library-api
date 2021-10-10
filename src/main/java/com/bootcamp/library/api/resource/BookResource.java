package com.bootcamp.library.api.resource;

import com.bootcamp.library.api.dto.FormBookDTO;
import com.bootcamp.library.api.dto.SimpleBookDTO;
import com.bootcamp.library.api.service.AuthorService;
import com.bootcamp.library.api.service.BookService;

import java.util.Collection;
import java.util.stream.Collectors;

/** This handle our book service
 *
 * @author claudio
 * create on 2021/09/26
 * @see BookService
 * @see AuthorService
 */
public class BookResource {
    private static final BookResource instance = new BookResource();
    private BookResource () {}

    private final BookService bookService = BookService.getInstance();
    private final AuthorService authorService = AuthorService.getInstance();

    public static BookResource getInstance() {
        return instance;
    }

    public SimpleBookDTO getBook (String isbn) {
        return SimpleBookDTO.parse(bookService.getBook(isbn));
    }




}
