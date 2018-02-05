package ru.gavrilov.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gavrilov.core.users.model.User;

@Repository
public interface UserRepositories extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
}
