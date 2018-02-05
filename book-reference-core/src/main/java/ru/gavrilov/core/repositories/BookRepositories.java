package ru.gavrilov.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gavrilov.core.books.model.Book;

@Repository
public interface BookRepositories extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book> {
}
