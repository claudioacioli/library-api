package com.bootcamp.library.api.model;

import lombok.*;

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
public class Author {
    private String name;
    private String email;
    private String resume;
    private LocalDate birthday;
}