package com.bootcamp.library.api.service;

import com.bootcamp.library.api.model.Book;

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
}
