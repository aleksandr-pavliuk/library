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
public class AuthorController extends AbstractController<Author> {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        List<Author> authors = authorService.getAll();
        return authors;
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
