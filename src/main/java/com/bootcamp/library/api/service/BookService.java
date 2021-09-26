package com.bootcamp.library.api.service;

public class BookService {
    private static final BookService instance = new BookService();
    private BookService () {}

    public static BookService getInstance() {
        return instance;
    }
}
