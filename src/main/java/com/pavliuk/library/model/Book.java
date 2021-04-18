package com.pavliuk.library.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */


@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Author)) return false;

        return id != null && id.equals(((Book) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}