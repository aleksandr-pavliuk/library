package com.pavliuk.library.controller;

import com.pavliuk.library.entity.Book;
import com.pavliuk.library.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class BookController extends AbstractController<Book> {
    @Autowired
    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    @GetMapping("/books")
    public List<Book> getAllAction() {
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
        bookService.save(book);
        System.out.println("Book Saved Successfully");
    }

    @Override
    @DeleteMapping("/books/{bookId}")
    public void deleteAction(@PathVariable(name = "bookId") Long bookId) {
        bookService.delete(bookId);
        System.out.println("Book Deleted Successfully");
    }
}
