package com.bootcamp.library.api.service;

import com.bootcamp.library.api.model.Author;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/** This service handle the Author model needs
 *
 * @author claudio
 * @see Author
 * create on 2021/09/26
 */
public class AuthorService {
    private static final AuthorService instance = new AuthorService();
    private AuthorService () {
        addAuthor(
                "Dale Carnegie",
                "dale_carnegie@gmail.com",
                "Dale Carnegie (born 1988)  was an American writer and lecturer, " +
                        "and the developer of courses in self-improvement, " +
                        "salesmanship, corporate training, public speaking, and interpersonal skills.",
                LocalDate.parse("11/24/1988", DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        );

        addAuthor(
                "Cal Newport",
                "calnewport@gmail.com",
                "Cal Newport (born 1982/06/23)" +
                        " is an American non-fiction author and associate professor " +
                        "of computer science at Georgetown University.",
                LocalDate.parse("1982/06/23", DateTimeFormatter.ofPattern("yyyy/MM/dd"))
        );

    }

    private final Map<String, Author> mapOfAuthors = new HashMap<>();

    public static AuthorService getInstance() {
        return instance;
    }

    public void addAuthor (String name, String email, String resume, LocalDate birthday) {
        mapOfAuthors.put(email, new Author(name, email, resume, birthday));
    }

    public Collection<Author> getAll () {
        return mapOfAuthors.values();
    }

    public Author getAuthor (String email) {
        return mapOfAuthors.get(email);
    }
}