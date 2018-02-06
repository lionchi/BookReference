package ru.gavrilov.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ru.gavrilov.core.books.model.Book;


public interface BookRepositories extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book> {
}
