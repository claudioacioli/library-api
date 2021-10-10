package com.bootcamp.library.api.model;

import lombok.*;

import javax.persistence.*;
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
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "pages")
    private Integer numberOfPages;

    @ManyToOne
    private Author author;

    public Book(String isbn, String title, LocalDate releaseDate, Integer numberOfPages, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.releaseDate = releaseDate;
        this.numberOfPages = numberOfPages;
        this.author = author;
    }
}
