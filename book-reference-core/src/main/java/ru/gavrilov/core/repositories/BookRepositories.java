package ru.gavrilov.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gavrilov.core.books.model.Book;

public interface BookRepositories extends JpaRepository<Book,Long> {
}
