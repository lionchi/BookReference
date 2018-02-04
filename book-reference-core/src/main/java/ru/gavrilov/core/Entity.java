package ru.gavrilov.core;

import javax.persistence.*;

@MappedSuperclass
public abstract class Entity {
    public static final String ID_PROPERTY = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
