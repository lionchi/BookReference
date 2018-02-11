package ru.gavrilov.core.authors.dto;

import ru.gavrilov.core.books.dto.BookDTO;

import java.util.List;

public class AuthorDTO {

    private Long id;

    private String fullName;

    private List<BookDTO> books;

    public AuthorDTO() {
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

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
