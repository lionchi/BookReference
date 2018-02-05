package ru.gavrilov.core.books.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gavrilov.core.authors.model.Author;
import ru.gavrilov.core.users.model.User;

import javax.persistence.*;
import javax.annotation.Nonnull;
import java.util.Date;

@Entity
@Table(name = "books")
@EntityListeners(AuditingEntityListener.class)
public class Book extends ru.gavrilov.core.abstracts.Entity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date_release")
    private Date dateRelease;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nonnull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Nonnull
    public Date getDate_release() {
        return dateRelease;
    }

    public void setDate_release(Date date_release) {
        this.dateRelease = date_release;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
