package com.pavliuk.library.repository;

import com.pavliuk.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);
}
