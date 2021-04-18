package com.pavliuk.library;

import com.pavliuk.library.model.Author;
import com.pavliuk.library.model.Book;
import com.pavliuk.library.repository.AuthorRepository;
import com.pavliuk.library.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@DataJpaTest
@Commit
public class ManyToManyTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @BeforeEach
    public void booksShouldBeAdded() {
        Author author1 = new Author("author1");
        Book b1 = new Book("book1", "description book1");
        Book b2 = new Book("book2", "description book2");
        author1.addBook(b1);
        author1.addBook(b2);
        authorRepository.save(author1);
        Author author2 = new Author("author2");
        author2.addBook(b1);
        authorRepository.save(author2);
        Assertions.assertEquals(2, authorRepository.count());
        Assertions.assertEquals(2, bookRepository.count());
    }
    @Test
    public void whenDeleteAuthorFromBook_thenOneDeleteStatement() {
        Author author = authorRepository.findByName("author1");
        Book book = bookRepository.findByTitle("book1");
        author.removeBook(book);
    }
}
