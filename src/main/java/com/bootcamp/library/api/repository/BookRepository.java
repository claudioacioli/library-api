package com.bootcamp.library.api.repository;

import com.bootcamp.library.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/** Manage data manipulation of books.
 *
 * @author claudio
 * create on 2021/10/10
 * @see Book
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    Boolean existsByIsbn (String isbn);
    Book findByIsbn(String isbn);
    void deleteByIsbn(String isbn);
}