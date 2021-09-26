package com.bootcamp.library.api.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/** This describes a form required Book interface to our clients
 *
 * @author claudio
 * create on 2021/09/26
 * @see com.bootcamp.library.api.model.Book
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FormBookDTO {

    @NotBlank
    private String isbn;
    @NotBlank
    private String title;
    @PastOrPresent
    private LocalDate releaseDate;

    @Size(min=100)
    private int numberOfPages;

    @NotBlank
    @Email
    private String emailOfAuthor;
}
