package com.bootcamp.library.api.service;

import com.bootcamp.library.api.dto.ItemAuthorBooksDTO;
import com.bootcamp.library.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ResumeService {

    @Autowired
    private BookRepository bookRepository;

    public Collection<ItemAuthorBooksDTO> getAuthorXBooks() {
        return bookRepository.getAuthorXBooks();
    }

}
