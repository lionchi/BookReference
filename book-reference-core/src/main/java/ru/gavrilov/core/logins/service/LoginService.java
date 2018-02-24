package ru.gavrilov.core.logins.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrilov.core.abstracts.Guard;
import ru.gavrilov.core.mappers.MapperFactory;
import ru.gavrilov.core.mappers.UserMapper;
import ru.gavrilov.core.repositories.UserRepositories;
import ru.gavrilov.core.users.model.User;

import javax.annotation.Nonnull;

@Service
@Transactional
public class LoginService {
    private UserRepositories userRepositories;
    private static  final UserMapper userMapper = MapperFactory.createMapper(UserMapper.class);

    public LoginService(@Nonnull UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }
    
    public User getUser(String login, String password){
        User user = userRepositories.findByLoginAndPassword(login,password);
        Guard.notNull(user, "Данный пользователь незарегистрирован");
        return user;
    }
}
