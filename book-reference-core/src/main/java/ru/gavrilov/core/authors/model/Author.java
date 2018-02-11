package ru.gavrilov.core.authors.model;

import ru.gavrilov.core.books.model.Book;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="authors")
public class Author extends ru.gavrilov.core.abstracts.Entity {

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Book> books;

    public Author() {
    }

    public Author(String fullName) {
        this.fullName = fullName;
        this.books = books;
    }

    @Nonnull
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Nullable
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
