package com.pavliuk.library.service.impl;

import com.pavliuk.library.entity.Book;
import com.pavliuk.library.repository.BookRepository;
import com.pavliuk.library.service.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class BookService implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List getAll() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @Override
    public Book get(long id) {
        Optional<Book> optBook = bookRepository.findById(id);
        return optBook.get();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(long id) {
        bookRepository.deleteById(id);
    }
}
