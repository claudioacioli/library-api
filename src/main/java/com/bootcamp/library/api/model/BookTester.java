package com.bootcamp.library.api.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** This implements a simple test driver to handle Book class
 *
 * @author claudio
 * create on 2021/09/12
 * @see Book
 * @see Author
 */
public class BookTester {
    public static void main(String[] args) {
        Author author = new Author(
                "Dale Carnegie",
                "dale_carnegie@gmail.com",
                "Dale Carnegie (born 1988)  was an American writer and lecturer, " +
                        "and the developer of courses in self-improvement, " +
                        "salesmanship, corporate training, public speaking, and interpersonal skills.",
                LocalDate.parse("11/24/1988", DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        );

        Book book = new Book(
                "1-4391-6734-6",
                "How to Win Friends and Influence People",
                LocalDate.parse("10/24/1936", DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                291,
                author
        );

        System.out.println(book);
    }
}
