package com.bootcamp.library.api.service;

import com.bootcamp.library.api.dto.FormBookDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/** This is service test driver
 *
 * @author claudio
 * create on 2021/09/26
 * @see BookService
 * @see AuthorService
 */
public class BookServiceTester {
    public static void main(String[] args) {
        BookService bookService = new BookService();

        bookService.addBook(
                new FormBookDTO(
                "1-4391-6734-6",
                "How to Win Friends and Influence People ",
                LocalDate.parse("10/24/1936", DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                291,
                "dale_carnegie@gmail.com"
                )
        );
    }
}
