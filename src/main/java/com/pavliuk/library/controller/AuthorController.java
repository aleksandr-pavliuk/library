package com.pavliuk.library.controller;

import com.pavliuk.library.model.Author;
import com.pavliuk.library.model.Book;
import com.pavliuk.library.service.impl.AuthorService;
import com.pavliuk.library.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@RestController
public class AuthorController extends AbstractController<Author> {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthors() {
        final List<Author> authors = authorService.getAll();

        return authors != null &&  !authors.isEmpty()
                ? new ResponseEntity<>(authors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/authors/{authorId}")
    public Author getAction(@PathVariable(name = "authorId") Long authorId) {
        return authorService.get(authorId);
    }

    @DeleteMapping("/authors/{authorId}")
    public void deleteAction(@PathVariable(name = "authorId") Long authorId) {
        Author author = authorService.get(authorId);
        author.getBooks().forEach(book -> book.getAuthors().remove(author));
        authorService.delete(authorId);
    }

    @GetMapping("/authors/{authorId}/books")
    public Set<Book> getBooks(@PathVariable(name = "authorId") Long authorId) {
        return authorService.get(authorId).getBooks();
    }
}
