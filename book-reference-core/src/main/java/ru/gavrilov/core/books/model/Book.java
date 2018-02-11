package ru.gavrilov.core.books.model;

import ru.gavrilov.core.authors.model.Author;
import ru.gavrilov.core.users.model.User;

import javax.annotation.Nullable;
import javax.persistence.*;
import javax.annotation.Nonnull;

@Entity
@Table(name = "books")
public class Book extends ru.gavrilov.core.abstracts.Entity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "year_publication", length = 10)
    private String yearOfPublication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String title, String description, String yearOfPublication, User user) {
        this.title = title;
        this.description = description;
        this.yearOfPublication = yearOfPublication;
        this.user = user;
        this.author = author;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Nullable
    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Nonnull
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Nullable
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
