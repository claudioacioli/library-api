package com.bootcamp.library.api.service;

import com.bootcamp.library.api.dto.FormBookDTO;
import com.bootcamp.library.api.dto.SimpleBookDTO;
import com.bootcamp.library.api.model.Author;
import com.bootcamp.library.api.model.Book;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/** This service handle the Book model needs
 *
 * @author claudio
 * @see Book
 * @see Author
 * create on 2021/09/26
 */
public class BookService {
    private static final BookService instance = new BookService();
    private BookService () {}

    private final AuthorService authorService = AuthorService.getInstance();
    private final Map<String, Book> mapOfBooks = new HashMap<>();

    public static BookService getInstance() {
        return instance;
    }

    public Collection<SimpleBookDTO> getAll () {
        return mapOfBooks
                .values()
                .stream()
                .map(SimpleBookDTO::parse)
                .collect(Collectors.toList())
        ;
    }

    public void addBook (String isbn, String title, LocalDate releaseDate, int numberOfPages, Author author) {
        mapOfBooks.put(
            isbn,
            new Book(
                isbn,
                title,
                releaseDate,
                numberOfPages,
                author
            )
        );
    }

    public void addBook (FormBookDTO book) {
        addBook(
            book.getIsbn(),
            book.getTitle(),
            book.getReleaseDate(),
            book.getNumberOfPages(),
            authorService.getAuthor(book.getEmailOfAuthor()).toAuthor()
        );
    }

    public SimpleBookDTO getBook(String isbn) {
        Book book = mapOfBooks.get(isbn);
        if (book == null)
            throw new IllegalArgumentException("There isn't book with this isbn");

        return SimpleBookDTO.parse(book);
    }

    public void updateBook (String isbn, String title, LocalDate releaseDate, int numberOfPages, Author author) {
        mapOfBooks.replace(
            isbn,
            new Book(
                isbn,
                title,
                releaseDate,
                numberOfPages,
                author
            )
        );
    }

    public void updateBook (FormBookDTO book) {
        updateBook(
            book.getIsbn(),
            book.getTitle(),
            book.getReleaseDate(),
            book.getNumberOfPages(),
            authorService.getAuthor(book.getEmailOfAuthor()).toAuthor()
        );
    }

    public void deleteBook (String isnb) {
        mapOfBooks.remove(isnb);
    }
}
