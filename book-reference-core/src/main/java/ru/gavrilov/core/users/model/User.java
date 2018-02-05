package ru.gavrilov.core.users.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gavrilov.core.abstracts.Human;
import ru.gavrilov.core.books.model.Book;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User extends Human {

    @Column(name="login",length = 25)
    private String login;

    @Column(name="password",length = 25)
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Book> books;

    public User() {
    }

    @Nonnull
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Nonnull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Nonnull
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Nonnull
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
