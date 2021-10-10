package com.bootcamp.library.api.repository;

import com.bootcamp.library.api.dto.ItemAuthorBooksDTO;
import com.bootcamp.library.api.model.Book;
import com.bootcamp.library.api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

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

    @Query( "select new com.bootcamp.library.api.dto.ItemAuthorBooksDTO( " +
            "           (select a.name from authors a where a.id = b.author), " +
            "           sum(1), " +
            "           sum(1) * 1.0/ (select count(*) from Book) * 1.0 " +
            "      ) " +
            " from Book b " +
            "group by b.author")
    Collection<ItemAuthorBooksDTO> getAuthorXBooks();

}