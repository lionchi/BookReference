package ru.gavrilov.core.mappers;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import ru.gavrilov.core.books.dto.BookDTO;
import ru.gavrilov.core.books.model.Book;

@Mapper(withCustomFields = {
        @Field({"user.id","userId"}), @Field({"author.id","authorId"})
}, withCustom = BookCustomMapper.class, withIgnoreMissing = IgnoreMissing.ALL)
public interface BookMapper {

    BookDTO asBookDTO(Book book);

    Book asBook(BookDTO source);
}
