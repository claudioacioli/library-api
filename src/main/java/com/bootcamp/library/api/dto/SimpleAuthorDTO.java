package com.bootcamp.library.api.dto;

import lombok.*;

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
    private String name;
    private String email;
    private LocalDate birthday;
}
