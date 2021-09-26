package com.bootcamp.library.api.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** This is service test driver
 *
 * @author claudio
 * @see AuthorService
 * create on 2021/09/26
 */
public class AuthorServiceTester {
    public static void main(String[] args) {
        AuthorService authorService = AuthorService.getInstance();

        authorService.addAuthor(
                "Dale Carnegie",
                "dale_carnegie@gmail.com",
                "Dale Carnegie (born 1988)  was an American writer and lecturer, " +
                        "and the developer of courses in self-improvement, " +
                        "salesmanship, corporate training, public speaking, and interpersonal skills.",
                LocalDate.parse("11/24/1988", DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        );

        authorService.addAuthor(
                "Cal Newport",
                "calnewport@gmail.com",
                "Cal Newport (born 1982/06/23)" +
                        " is an American non-fiction author and associate professor " +
                        "of computer science at Georgetown University.",
                LocalDate.parse("1982/06/23", DateTimeFormatter.ofPattern("yyyy/MM/dd"))
        );

        authorService.getAll().forEach(System.out::println);

        System.out.println(authorService.getAuthor("calnewport@gmail.com"));
    }
}
