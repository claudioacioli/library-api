package com.bootcamp.library.api.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** This implements a simple test driver to handle Author class
 *
 * @author claudio
 * create on 2021/09/12
 * @see Author
 */
public class AuthorTester {
    public static void main(String[] args) {
        Author author1 = new Author();
        author1.setName("Cal Newport");
        author1.setEmail("calnewport@gmail.com");
        author1.setBirthday(LocalDate.parse("1982/06/23", DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        author1.setResume(
                author1.getName() + " (born " + author1.getBirthday().format(DateTimeFormatter.ofPattern("yyyy")) + ")" +
                " is an American non-fiction author and associate professor " +
                        "of computer science at Georgetown University.");

        println(author1);

        Author author2 = new Author(
                "Dale Carnegie",
                "dale_carnegie@gmail.com",
                "Dale Carnegie (born 1988)  was an American writer and lecturer, " +
                        "and the developer of courses in self-improvement, " +
                        "salesmanship, corporate training, public speaking, and interpersonal skills.",
                LocalDate.parse("11/24/1988", DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        );

        println(author2.getName());
        println(author2.getBirthday().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        println(author2.getEmail());
        println(author2.getResume());
    }

    private static <T> void println (T message) {
        System.out.println(message);
    }
}
