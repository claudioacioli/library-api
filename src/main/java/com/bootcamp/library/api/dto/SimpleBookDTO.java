package com.bootcamp.library.api.dto;

import com.bootcamp.library.api.model.Book;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

/** This describes a Book interface to our clients
 *
 * @author claudio
 * create on 2021/09/26
 * @see Book
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SimpleBookDTO {
    private String isbn;
    private String title;
    private LocalDate releaseDate;
    private int numberOfPages;
    private String emailOfAuthor;

    public static SimpleBookDTO parse (Book book) {
        ModelMapper modelMapper = new ModelMapper();
        SimpleBookDTO dto = modelMapper.map(book, SimpleBookDTO.class);
        dto.emailOfAuthor = book.getAuthor().getEmail();
        return dto;
    }
}