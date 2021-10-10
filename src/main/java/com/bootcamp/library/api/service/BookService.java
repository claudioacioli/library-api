package com.bootcamp.library.api.service;

import com.bootcamp.library.api.dto.FormBookDTO;
import com.bootcamp.library.api.dto.SimpleBookDTO;
import com.bootcamp.library.api.model.Author;
import com.bootcamp.library.api.model.Book;
import com.bootcamp.library.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/** This service handle the Book model needs
 *
 * @author claudio
 * @see Book
 * @see Author
 * create on 2021/09/26
 */

@Service
public class BookService {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookRepository bookRepository;

    public Collection<SimpleBookDTO> getAll () {
        return bookRepository
                .findAll()
                .stream()
                .map(SimpleBookDTO::parse)
                .collect(Collectors.toList())
        ;
    }

    public SimpleBookDTO getBook(String isbn) {
        if (!bookRepository.existsByIsbn(isbn))
            throw new IllegalArgumentException("There isn't book with this isbn");

        return SimpleBookDTO.parse(bookRepository.findByIsbn(isbn));
    }

    // TODO: Think about better approach
    @Transactional
    public void addBook (FormBookDTO book) {
        String email = book.getEmailOfAuthor();
        Book newBook = book.toBook();
        Author author = authorService.getAuthor(email).toAuthor();
        System.out.println(author);
        newBook.setAuthor(authorService.getAuthor(email).toAuthor());
        bookRepository.save(newBook);
    }

    // TODO: Think about better approach
    @Transactional
    public void updateBook (FormBookDTO book) {
        String isbn = book.getIsbn();
        Book updatedBook = book.toBook();

        if (bookRepository.existsByIsbn(isbn)) {
            Long id = bookRepository.findByIsbn(isbn).getId();
            updatedBook.setId(id);
        }

        bookRepository.save(updatedBook);
    }

    @Transactional
    public void deleteBook (String isnb) {
        bookRepository.deleteByIsbn(isnb);
    }
}
