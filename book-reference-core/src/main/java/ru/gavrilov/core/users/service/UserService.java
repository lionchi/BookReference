package ru.gavrilov.core.users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrilov.core.abstracts.Guard;
import ru.gavrilov.core.books.model.Book;
import ru.gavrilov.core.mappers.BookMapper;
import ru.gavrilov.core.mappers.MapperFactory;
import ru.gavrilov.core.mappers.UserMapper;
import ru.gavrilov.core.repositories.UserRepositories;
import ru.gavrilov.core.users.dto.UserDTO;
import ru.gavrilov.core.users.model.User;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private UserRepositories userRepositories;
    private static  final UserMapper userMapper = MapperFactory.createMapper(UserMapper.class);
    private static final BookMapper bookMapper = MapperFactory.createMapper(BookMapper.class);

    public UserService(@Nonnull UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public List<User> getAllUser() {
        return userRepositories.findAll();
    }

    public User createUser(@Nonnull UserDTO userDto) {
        User user = userMapper.asUser(userDto);
        User saveUser = userRepositories.save(user);
        return saveUser;
    }

    public User getUserById(@Nonnull Long userId) {
        User user = userRepositories.findOne(userId);
        Guard.notNull(user,"Выбранный пользователь не зарегистрирован");
        return user;
    }

    public User updateUser(@Nonnull Long userId,
                           @Nonnull UserDTO userDetails) {
        User user = userRepositories.findOne(userId);
        Guard.notNull(user,"Выбранный пользователь не зарегистрирован");
        user.setLogin(userDetails.getLogin());
        user.setPassword((userDetails.getPassword()));
        user.setEmail((userDetails.getEmail()));
        List<Book> books = userDetails.getBooks()
                .stream()
                .map(bookMapper::asBook)
                .collect(Collectors.toList());
        user.setBooks(books);
        user.setFullName((userDetails.getFullName()));
        user.setSex((userDetails.getSex()));
        user.setDateOfRegistration((userDetails.getDateOfRegistration()));

        User updatedUser = userRepositories.save(user);
        return updatedUser;
    }

    public void deleteUser(@Nonnull Long userId) {
        User user = userRepositories.findOne(userId);
        Guard.notNull(user,"Выбранный пользователь не зарегистрирован");
        userRepositories.delete(user);
    }
}
