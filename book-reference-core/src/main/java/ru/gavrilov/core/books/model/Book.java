package ru.gavrilov.core.books.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gavrilov.core.authors.model.Author;
import ru.gavrilov.core.users.model.User;

import javax.annotation.Nullable;
import javax.persistence.*;
import javax.annotation.Nonnull;
import java.util.Date;

@Entity
@Table(name = "books")
@EntityListeners(AuditingEntityListener.class)
public class Book extends ru.gavrilov.core.abstracts.Entity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date_release")
    private Date dateRelease;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String title, String description, Date dateRelease, User user) {
        this.title = title;
        this.description = description;
        this.dateRelease = dateRelease;
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
    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
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
