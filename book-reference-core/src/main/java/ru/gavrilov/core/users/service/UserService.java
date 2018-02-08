package ru.gavrilov.core.users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrilov.core.repositories.UserRepositories;
import ru.gavrilov.core.users.model.User;

import javax.annotation.Nonnull;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepositories userRepositories;

    public UserService(@Nonnull UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public List<User> getAllUser() {
        return userRepositories.findAll();
    }

    public User createUser(@Nonnull User user) {
        User saveUser = userRepositories.save(user);
        return saveUser;
    }

    public User getUserById(@Nonnull Long userId) {
        User user = userRepositories.findOne(userId);
        if (user == null) {
            //return ResponseEntity.notFound().build(); надо обработать ошибку
        }
        return user;
    }

    public User updateUser(@Nonnull Long userId,
                           @Nonnull User userDetails) {
        User user = userRepositories.findOne(userId);
        if (user == null) {
            //return ResponseEntity.notFound().build(); надо обработать ошибку
        }
        user.setLogin(userDetails.getLogin());
        user.setPassword((userDetails.getPassword()));
        user.setEmail((userDetails.getEmail()));
        user.setBooks((userDetails.getBooks()));
        user.setFullName((userDetails.getFullName()));
        user.setSex((userDetails.getSex()));
        user.setDateOfBrith((userDetails.getDateOfBrith()));

        User updatedUser = userRepositories.save(user);
        return updatedUser;
    }

    public void deleteUser(@Nonnull Long userId) {
        User user = userRepositories.findOne(userId);
        if (user == null) {
            //return ResponseEntity.notFound().build(); надо обработать ошибку
        }

        userRepositories.delete(user);
    }
}
