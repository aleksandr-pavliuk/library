package com.pavliuk.library.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "author_name")
    private String name;

    public Author(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> Books = new HashSet<>();

    public void addBook(Book book) {
        getBooks().add(book);
        book.getAuthors().add(this);
    }

    public void removeBook(Book book) {
        getBooks().remove(book);
        book.getAuthors().remove(this);
    }

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

    public Set<Book> getBooks() {
        return Books;
    }

    public void setBooks(Set<Book> books) {
        this.Books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Author)) return false;

        return id != null && id.equals(((Author) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
