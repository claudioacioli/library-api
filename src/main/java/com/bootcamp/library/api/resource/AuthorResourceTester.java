package com.bootcamp.library.api.resource;

import com.bootcamp.library.api.dto.FormAuthorDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** This is service test driver
 *
 * @author claudio
 * @see AuthorResource
 * create on 2021/09/26
 */
public class AuthorResourceTester {
    public static void main(String[] args) {
        AuthorResource authorResource = AuthorResource.getInstance();
        System.out.println(authorResource.getAuthor("calnewport@gmail.com"));
    }
}
