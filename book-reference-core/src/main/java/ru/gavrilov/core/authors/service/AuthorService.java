package ru.gavrilov.core.authors.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrilov.core.abstracts.Guard;
import ru.gavrilov.core.authors.dto.AuthorDTO;
import ru.gavrilov.core.authors.model.Author;
import ru.gavrilov.core.books.model.Book;
import ru.gavrilov.core.mappers.AuthorMapper;
import ru.gavrilov.core.mappers.BookMapper;
import ru.gavrilov.core.mappers.MapperFactory;
import ru.gavrilov.core.repositories.AuthorRepository;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorService {

    private AuthorRepository authorRepository;
    private static final AuthorMapper authorMapper = MapperFactory.createMapper(AuthorMapper.class);
    private static final BookMapper bookMapper = MapperFactory.createMapper(BookMapper.class);

    public AuthorService(@Nonnull AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public Author createAuthor(@Nonnull AuthorDTO authorDto) {
        Author author = authorMapper.asAuthor(authorDto);
        Author saveAuthor = authorRepository.save(author);
        return saveAuthor;
    }

    public Author getAuthorById(@Nonnull Long authorId) {
        Author author = authorRepository.findOne(authorId);
        Guard.notNull(author, "Выбранного автора не сущетсвует");
        return author;
    }

    public Author updateAuthor(@Nonnull Long authorId,
                               @Nonnull AuthorDTO authorDetails) {
        Author author = authorRepository.findOne(authorId);
        Guard.notNull(author, "Выбранного автора не сущетсвует");
        author.setFullName(authorDetails.getFullName());
        List<Book> books = authorDetails.getBooks()
                .stream()
                .map(bookMapper::asBook)
                .collect(Collectors.toList());
        author.setBooks(books);

        Author updatedAuthor= authorRepository.save(author);
        return updatedAuthor;
    }

    public void deleteAuthor(@Nonnull Long authorId) {
        Author author = authorRepository.findOne(authorId);
        Guard.notNull(author, "Выбранного автора не сущетсвует");
        authorRepository.delete(author);
    }
}
