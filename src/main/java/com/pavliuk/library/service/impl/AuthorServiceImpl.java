package com.pavliuk.library.service.impl;

import com.pavliuk.library.model.Author;
import com.pavliuk.library.repository.AuthorRepository;
import com.pavliuk.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List getAll() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }

    @Override
    public Author get(long id) {
        Optional<Author> optAuthor = authorRepository.findById(id);
        return optAuthor.orElse(null);
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void update(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void delete(long id) {
        authorRepository.deleteById(id);
    }
}
