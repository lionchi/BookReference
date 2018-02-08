package ru.gavrilov.core.mappers;

import ru.gavrilov.core.books.model.Book;

public class BookCustomMapper {
    public String addressAsString(Book source){

        return source.toString();
    }
}
