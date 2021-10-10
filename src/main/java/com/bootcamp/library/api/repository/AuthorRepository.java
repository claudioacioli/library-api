package com.bootcamp.library.api.repository;

import com.bootcamp.library.api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/** Manage data manipulation of authors.
 *
 * @author claudio
 * create on 2021/09/26
 * @see Author
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
