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

    public Collection<SimpleBookDTO> getAll () {
        return bookService
                .getAll()
                .stream()
                .map(SimpleBookDTO::parse)
                .collect(Collectors.toList());
    }

    public SimpleBookDTO getBook (String isbn) {
        return SimpleBookDTO.parse(bookService.getBook(isbn));
    }

    public void addBook (FormBookDTO book) {
        bookService.addBook(
            book.getIsbn(),
            book.getTitle(),
            book.getReleaseDate(),
            book.getNumberOfPages(),
            authorService.getAuthor(book.getEmailOfAuthor()).toAuthor()
        );
    }

    public void updateBook (FormBookDTO book) {
        bookService.updateBook(
            book.getIsbn(),
            book.getTitle(),
            book.getReleaseDate(),
            book.getNumberOfPages(),
            authorService.getAuthor(book.getEmailOfAuthor()).toAuthor()
        );
    }

    public void removeBook (String isbn) {
        bookService.deleteBook(isbn);
    }
}
