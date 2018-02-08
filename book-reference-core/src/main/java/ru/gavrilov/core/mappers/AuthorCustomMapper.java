package ru.gavrilov.core.mappers;

import ru.gavrilov.core.authors.model.Author;

public class AuthorCustomMapper {

    public String addressAsString(Author source){

        return source.toString();
    }
}
