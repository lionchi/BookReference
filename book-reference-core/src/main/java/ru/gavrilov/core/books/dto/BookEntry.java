package ru.gavrilov.core.books.dto;

import ru.gavrilov.core.annotations.MappedEntity;
import ru.gavrilov.core.books.model.Book;

import java.util.Date;

@MappedEntity(Book.class)
public class BookEntry {
    private Long id;
    private String title;
    private String description;
    private Date date_release;

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

    public Date getDate_release() {
        return date_release;
    }

    public void setDate_release(Date date_release) {
        this.date_release = date_release;
    }
}
