package com.pavliuk.library.controller;

import com.pavliuk.library.model.Author;
import com.pavliuk.library.model.Book;
import com.pavliuk.library.service.impl.AuthorService;
import com.pavliuk.library.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@RestController
public class BookController extends AbstractController<Book> {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        List<Book> books = bookService.getAll();
        return books;
    }

    @Override
    @GetMapping("/books/{bookId}")
    public Book getAction(@PathVariable(name = "bookId") Long bookId) {
        return bookService.get(bookId);
    }

    @Override
    @PostMapping("/books")
    public void saveAction(Book book) {
        addAuthors(book);
        bookService.save(book);
    }

    @Override
    @PutMapping("/books/{bookId}")
    public void updateAction(@RequestBody Book book,
                             @PathVariable(name = "bookId") Long bookId) {
        Book id = bookService.get(bookId);
        if (id != null) {
            bookService.update(book);
        }
    }

    @Override
    @DeleteMapping("/books/{bookId}")
    public void deleteAction(@PathVariable(name = "bookId") Long bookId) {
        bookService.delete(bookId);
    }

    public void addAuthors(Book book) {
        if (book.getBookAuthors() != null && book.getBookAuthors().size() != 0) {
            book.getBookAuthors().forEach(author -> authorService.save(author));
        }
    }

    public Set<Author> getAuthors(Book book) {
        return book.getBookAuthors();
    }
}
