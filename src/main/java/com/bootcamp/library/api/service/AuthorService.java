package com.bootcamp.library.api.service;

import com.bootcamp.library.api.model.Author;

import java.time.LocalDate;
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
    private AuthorService () {}

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
