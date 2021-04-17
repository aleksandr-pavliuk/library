package com.pavliuk.library.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> bookAuthors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Author> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(Set<Author> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
}
