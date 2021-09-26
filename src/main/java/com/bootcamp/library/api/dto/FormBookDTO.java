package com.bootcamp.library.api.dto;

import lombok.*;

import javax.validation.constraints.*;
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

    @NotNull
    @PastOrPresent
    private LocalDate releaseDate;

    @NotNull
    @Min(100)
    private int numberOfPages;

    @NotBlank
    @Email
    private String emailOfAuthor;
}
