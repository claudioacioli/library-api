package com.bootcamp.library.api.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

@Getter
@AllArgsConstructor
public class ItemAuthorBooksDTO {

    @JsonAlias("author_name")
    private final String authorName;

    @JsonAlias("quantity_of_books")
    private final Long quantityOfBooks;

    private final Double percent;
}
