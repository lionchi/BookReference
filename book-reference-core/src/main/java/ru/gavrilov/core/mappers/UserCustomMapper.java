package ru.gavrilov.core.mappers;

import ru.gavrilov.core.users.model.User;

public class UserCustomMapper {

    public String addressAsString(User source){

        return source.toString();
    }
}
