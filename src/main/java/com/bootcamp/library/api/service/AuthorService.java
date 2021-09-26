package com.bootcamp.library.api.service;

import com.bootcamp.library.api.model.Author;

/** This service handle the Author model needs
 *
 * @author claudio
 * @see Author
 * create on 2021/09/26
 */
public class AuthorService {
    private static final AuthorService instance = new AuthorService();
    private AuthorService () {}

    public static AuthorService getInstance() {
        return instance;
    }

}
