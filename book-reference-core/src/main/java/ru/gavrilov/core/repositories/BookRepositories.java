package ru.gavrilov.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ru.gavrilov.core.authors.model.Author;
import ru.gavrilov.core.books.model.Book;
import ru.gavrilov.core.users.model.User;

import java.util.List;


public interface BookRepositories extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book> {

    List<Book> findByAuthorAndUser(Author author, User user);
    List<Book> findByAuthor(Author author);
    List<Book> findByUser(User user);

}
