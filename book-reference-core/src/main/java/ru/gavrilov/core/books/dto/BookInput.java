package ru.gavrilov.core.books.dto;

import javax.validation.constraints.Size;
import java.util.Date;

public class BookInput {

    @Size(max = 50)
    private String title;

    @Size(max = 255)
    private String description;

    private Date date_release;

    public BookInput(String title, String description, Date date_release) {
        this.title = title;
        this.description = description;
        this.date_release = date_release;
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

    public Date getDateRelease() {
        return date_release;
    }

    public void setDateRelease(Date date_release) {
        this.date_release = date_release;
    }
}
