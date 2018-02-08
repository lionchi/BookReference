package ru.gavrilov.core.users.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gavrilov.core.books.model.Book;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User extends ru.gavrilov.core.abstracts.Entity {

    @Column(name = "full_name")
    private String fullName;

    @Column(name="login",length = 25, nullable = false)
    private String login;

    @Column(name="pass",length = 25, nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "sex", nullable = false)
    private Boolean sex;

    @Column(name = "date_birth", nullable = false)
    private Date dateOfBrith;

    @OneToMany(mappedBy = "user")
    private List<Book> books;

    public User() {
    }

    public User(String fullName, String login, String password, String email, Boolean sex, Date dateOfBrith) {
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.dateOfBrith = dateOfBrith;
    }

    @Nullable
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Nonnull
    public Date getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(Date dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }

    @Nullable
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
