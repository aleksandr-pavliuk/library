package com.pavliuk.library.repository;

import com.pavliuk.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
}
