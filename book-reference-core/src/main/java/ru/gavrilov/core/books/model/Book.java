package ru.gavrilov.core.books.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.annotation.Nonnull;

@Entity
@Table(name = "books")
@EntityListeners(AuditingEntityListener.class)
public class Book extends ru.gavrilov.core.Entity {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

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
}
