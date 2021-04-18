package com.pavliuk.library;

import com.pavliuk.library.model.Author;
import com.pavliuk.library.model.Book;
import com.pavliuk.library.repository.AuthorRepository;
import com.pavliuk.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = LibraryApplication.class)
class LibraryApplicationTests {

    @Autowired
    private AuthorRepository authorRepository;
	@Autowired
    private BookRepository bookRepository;

    @Test
    void contextLoads() {
    }

    /*@Test
    public void Should_save_author_and_return_not_null() {
        Author author = new Author();
        author.setId(1L);
        author.setName("First");
        authorRepository.save(author);
        List<Author> authors = authorRepository.findAll();
        assertFalse(authors.isEmpty());
    }

	@Test
	public void Should_save_book_and_return_not_null() {
		Book book = new Book();
		book.setId(1L);
		book.setTitle("First book");
		book.setDescription("First book description");
		bookRepository.save(book);
		List<Book> books = bookRepository.findAll();
		assertFalse(books.isEmpty());
	}

    @Test
    public void Should_save_author_with_books_and_return_authors_books_not_null() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("First book");
        book.setDescription("First book description");
        List<Book> books = new ArrayList<>();
        books.add(book);
        Author author = new Author();
        author.setId(1L);
        author.setName("First");
        author.setAuthorBooks((new HashSet<>(books)));
        assertFalse(author.getBooks().isEmpty());
    }

    @Test
    public void Should_save_book_with_authors_and_return_books_authors_not_null() {
        Author author = new Author();
        author.setId(1L);
        author.setName("First");
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        Book book = new Book();
        book.setId(1L);
        book.setTitle("First book");
        book.setDescription("First book description");
        book.setBookAuthors((new HashSet<>(authors)));
        assertFalse(book.getAuthors().isEmpty());
    }

    @Test
    public void Should_find_all_authors() {
		Book book = new Book();
		book.setId(1L);
		book.setTitle("First book");
		book.setDescription("First book description");
		List<Book>books = new ArrayList<>();
		books.add(book);
        Author author = new Author();
        author.setId(1L);
        author.setName("First");
        author.setAuthorBooks((new HashSet<>(books)));
        authorRepository.save(author);
        Author author2 = new Author();
        author2.setId(2L);
        author2.setName("Second");
        authorRepository.save(author2);
        List<Author> authors = authorRepository.findAll();
        assertEquals(2, authors.size());
    }

    @Test
    public void Should_find_all_books() {
        Author author = new Author();
        author.setId(1L);
        author.setName("First");
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        Book book = new Book();
        book.setId(1L);
        book.setTitle("First book");
        book.setDescription("First book description");
        book.setBookAuthors((new HashSet<>(authors)));
        bookRepository.save(book);
        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Second book");
        book2.setDescription("Second book description");
        bookRepository.save(book2);
        List<Book> books = bookRepository.findAll();
        assertEquals(2, books.size());
    }*/
}
