package ru.gavrilov.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.gavrilov.core.authors.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>, JpaSpecificationExecutor<Author>{
}
