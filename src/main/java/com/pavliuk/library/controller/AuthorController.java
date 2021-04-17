package com.pavliuk.library.controller;

import com.pavliuk.library.entity.Author;
import com.pavliuk.library.service.impl.AuthorService;
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
public class AuthorController extends AbstractController<Author> {

    @Autowired
    private AuthorService authorService;

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    @GetMapping("/authors")
    public List<Author> getAllAction() {
        List<Author> authors = authorService.getAll();
        return authors;
    }

    @GetMapping("/authors/{authorId}")
    public Author getAction(@PathVariable(name="authorId")Long authorId) {
        return authorService.get(authorId);
    }

    @Override
    @PostMapping("/authors")
    public void saveAction(Author author){
        authorService.save(author);
        System.out.println("Author Saved Successfully");
    }

    @DeleteMapping("/authors/{authorId}")
    public void deleteAction(@PathVariable(name="authorId")Long authorId){
        authorService.delete(authorId);
        System.out.println("Author Deleted Successfully");
    }


}
