package com.bootcamp.library.api.resource;

import com.bootcamp.library.api.dto.FormAuthorDTO;
import com.bootcamp.library.api.dto.SimpleAuthorDTO;
import com.bootcamp.library.api.service.AuthorService;

import java.util.Collection;
import java.util.stream.Collectors;

/** This handle our Author service
 *
 * @author claudio
 * create on 2021/09/26
 * @see com.bootcamp.library.api.model.Author
 */
public class AuthorResource {
    private static final AuthorResource instance = new AuthorResource();
    private AuthorResource() {}

    private final AuthorService authorService = AuthorService.getInstance();

    public static AuthorResource getInstance() {
        return instance;
    }

    public Collection<SimpleAuthorDTO> getAll () {
        return authorService.getAll()
                .stream()
                .map(SimpleAuthorDTO::parse)
                .collect(Collectors.toList());
    }

    public void addAuthor (FormAuthorDTO author) {
        authorService.addAuthor(author.getName(), author.getEmail(), author.getResume(), author.getBirthday());
    }

    public FormAuthorDTO getAuthor (String email) {
        return FormAuthorDTO.parse(authorService.getAuthor(email));
    }

}
