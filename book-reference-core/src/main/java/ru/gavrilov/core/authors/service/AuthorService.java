package ru.gavrilov.core.authors.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrilov.core.authors.model.Author;
import ru.gavrilov.core.repositories.AuthorRepository;

import javax.annotation.Nonnull;
import java.util.List;

@Service
@Transactional
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(@Nonnull AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public Author createAuthor(@Nonnull Author author) {
        Author saveAuthor = authorRepository.save(author);
        return saveAuthor;
    }

    public Author getAuthorById(@Nonnull Long authorId) {
        Author author = authorRepository.findOne(authorId);
        if (author == null) {
            //return ResponseEntity.notFound().build(); надо обработать ошибку
        }
        return author;
    }

    public Author updateAuthor(@Nonnull Long authorId,
                               @Nonnull Author authorDetails) {
        Author author = authorRepository.findOne(authorId);
        if (author == null) {
            //return ResponseEntity.notFound().build(); надо обработать ошибку
        }
        author.setFullName(authorDetails.getFullName());
        author.setBooks((authorDetails.getBooks()));

        Author updatedAuthor= authorRepository.save(author);
        return updatedAuthor;
    }

    public void deleteAuthor(@Nonnull Long authorId) {
        Author author = authorRepository.findOne(authorId);
        if (author == null) {
            //return ResponseEntity.notFound().build(); надо обработать ошибку
        }

        authorRepository.delete(author);
    }
}
