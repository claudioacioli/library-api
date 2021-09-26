package com.bootcamp.library.api.service;

import com.bootcamp.library.api.model.Author;
import com.bootcamp.library.api.model.Book;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookService {
    private static final BookService instance = new BookService();
    private BookService () {}

    private final Map<String, Book> mapOfBooks = new HashMap<>();

    public static BookService getInstance() {
        return instance;
    }

    public Collection<Book> getAll () {
        return mapOfBooks.values();
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

    public Book getBook(String isbn) {
        Book book = mapOfBooks.get(isbn);
        if (book == null)
            throw new IllegalArgumentException("There isn't book with this isbn");

        return book;
    }
}
