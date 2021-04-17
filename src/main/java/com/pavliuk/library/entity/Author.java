package com.pavliuk.library.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author_name")
    private String name;

    @ManyToMany(mappedBy = "bookAuthors")
    private Set<Book> authorBooks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(Set<Book> authorBooks) {
        this.authorBooks = authorBooks;
    }

}
