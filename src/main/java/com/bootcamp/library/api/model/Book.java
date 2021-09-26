package com.bootcamp.library.api.model;

import lombok.*;

import java.time.LocalDate;

/** This describes a book in the library
 *
 * @author claudio
 * create on 2021/09/26
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private String isbn;
    private String title;
    private LocalDate releaseDate;
    private int numberOfPages;
    private Author author;
}
