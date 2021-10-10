package com.bootcamp.library.api.service;

import com.bootcamp.library.api.dto.FormAuthorDTO;
import com.bootcamp.library.api.dto.SimpleAuthorDTO;
import com.bootcamp.library.api.model.Author;
import com.bootcamp.library.api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/** This service handle the Author model needs
 *
 * @author claudio
 * create on 2021/09/26
 * @see Author
 */

@Service
public class AuthorService {

    private static final AuthorService instance = new AuthorService();
    private AuthorService () {}

    @Autowired
    private AuthorRepository authorRepository;
    private final Map<String, Author> mapOfAuthors = new HashMap<>();

    public static AuthorService getInstance() {
        return instance;
    }


    public void addAuthor (FormAuthorDTO author) {
        authorRepository.save(author.toAuthor());
    }

    public void updateAuthor (FormAuthorDTO author) {
        authorRepository.save(author.toAuthor());
    }

    public void removeAuthor (String email) {
        authorRepository.deleteByEmail(email);
    }

    public Collection<SimpleAuthorDTO> getAll () {
        return authorRepository.findAll()
                .stream()
                .map(SimpleAuthorDTO::parse)
                .collect(Collectors.toList())
                ;
    }

    public FormAuthorDTO getAuthor (String email) {
        if (!authorRepository.existsByEmail(email))
            throw new IllegalArgumentException("There isn't author with this email");

        return FormAuthorDTO.parse(authorRepository.findByEmail(email));
    }
}
