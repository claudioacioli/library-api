package com.bootcamp.library.api.repository;

import com.bootcamp.library.api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/** Manage data manipulation of authors.
 *
 * @author claudio
 * create on 2021/10/10
 * @see Author
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByEmail(String email);
    Boolean existsByEmail(String email);
    void deleteByEmail(String email);
}
