package com.bootcamp.library.api.dto;

import com.bootcamp.library.api.model.Author;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

/** This describes a form required Author interface to our clients
 *
 * @author claudio
 * create on 2021/09/26
 * @see com.bootcamp.library.api.model.Author
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FormAuthorDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    private String resume;

    @Past
    private LocalDate birthday;

    public FormAuthorDTO (String name, String email, String resume, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.resume = resume;
        this.birthday = birthday;
    }

    public static FormAuthorDTO parse (Author author) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(author, FormAuthorDTO.class);
    }

    public Author toAuthor () {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Author.class);
    }
}
