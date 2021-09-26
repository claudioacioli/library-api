package com.bootcamp.library.api.resource;

import com.bootcamp.library.api.dto.SimpleAuthorDTO;
import com.bootcamp.library.api.model.Author;
import com.bootcamp.library.api.service.AuthorService;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.stream.Collectors;

/** This service encapsulate a Simple DTO to handle author
 *
 * @author claudio
 * @see AuthorService
 * create on 2021/09/26
 */
public class SimpleAuthorResource {
    private static final SimpleAuthorResource instance = new SimpleAuthorResource();
    private SimpleAuthorResource() {}

    private final AuthorService authorService = AuthorService.getInstance();
    private final ModelMapper modelMapper = new ModelMapper();

    public static SimpleAuthorResource getInstance() {
        return instance;
    }

    public Collection<SimpleAuthorDTO> getAll () {
        return authorService.getAll()
                .stream()
                .map(this::toSimpleAuthor)
                .collect(Collectors.toList());
    }

    private SimpleAuthorDTO toSimpleAuthor (Author author) {
        return modelMapper.map(author, SimpleAuthorDTO.class);
    }

    public void addAuthor (SimpleAuthorDTO author) {
        authorService.addAuthor(author.getName(), author.getEmail(), null, author.getBirthday());
    }

    public SimpleAuthorDTO getAuthor (String email) {
        return toSimpleAuthor(authorService.getAuthor(email));
    }

}
