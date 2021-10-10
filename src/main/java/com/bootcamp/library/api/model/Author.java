package com.bootcamp.library.api.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/** This describes an author of books
 *
 * @author claudio
 * create on 2021/09/12
 */

@Getter
@Setter
@ToString(exclude = "resume")
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String resume;
    private LocalDate birthday;

    public Author (String name, String email, String resume, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.resume = resume;
        this.birthday = birthday;
    }
}