package com.bootcamp.library.api.service;

import com.bootcamp.library.api.dto.FormAuthorDTO;
import com.bootcamp.library.api.dto.SimpleAuthorDTO;
import com.bootcamp.library.api.model.Author;
import com.bootcamp.library.api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

/** This service handle the Author model needs
 *
 * @author claudio
 * create on 2021/09/26
 * @see Author
 */

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public void addAuthor (FormAuthorDTO author) {
        authorRepository.save(author.toAuthor());
    }

    //TODO: Think about new approach! :-(
    @Transactional
    public void updateAuthor (FormAuthorDTO author) {
        Author newAuthor = author.toAuthor();
        String email = author.getEmail();

        if (authorRepository.existsByEmail(email)) {
            Long id = authorRepository.findByEmail(email).getId();
            newAuthor.setId(id);
        }

        authorRepository.save(newAuthor);
    }

    @Transactional
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
