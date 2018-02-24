package ru.gavrilov.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.gavrilov.core.users.model.User;

public interface UserRepositories extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    User findByLoginAndPassword(String login, String password);
}
