package ru.gavrilov.core.abstracts;

import javax.annotation.Nonnull;
import javax.persistence.*;

@MappedSuperclass
public abstract class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nonnull
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
