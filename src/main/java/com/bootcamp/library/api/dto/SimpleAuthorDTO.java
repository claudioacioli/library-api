package com.bootcamp.library.api.dto;

import com.bootcamp.library.api.model.Author;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

/** This describes a simple Author interface to our clients
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
public class SimpleAuthorDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthday;

    public static SimpleAuthorDTO parse (Author author) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(author, SimpleAuthorDTO.class);
    }

    public Author toAuthor () {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Author.class);
    }
}
