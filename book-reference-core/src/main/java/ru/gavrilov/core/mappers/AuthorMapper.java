package ru.gavrilov.core.mappers;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import ru.gavrilov.core.authors.dto.AuthorDTO;
import ru.gavrilov.core.authors.model.Author;

@Mapper(withCustom = AuthorCustomMapper.class,withIgnoreMissing = IgnoreMissing.ALL)
public interface AuthorMapper {
    AuthorDTO asAuthorDTO(Author source);

    Author asAuthor (AuthorDTO authorDTO);
}
