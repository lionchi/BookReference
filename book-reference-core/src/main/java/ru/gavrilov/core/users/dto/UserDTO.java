package ru.gavrilov.core.users.dto;

import ru.gavrilov.core.books.dto.BookDTO;
import ru.gavrilov.core.books.model.Book;

import java.util.Date;
import java.util.List;

public class UserDTO {

    private Long id;

    private String fullName;

    private String login;

    private String password;

    private String email;

    private Boolean sex;

    private Date dateOfBrith;

    private List<Book> books;

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(Date dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
