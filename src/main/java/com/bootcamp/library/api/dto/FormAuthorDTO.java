package com.bootcamp.library.api.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FormAuthorDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    private String resume;

    @Past
    private LocalDate birthday;
}
