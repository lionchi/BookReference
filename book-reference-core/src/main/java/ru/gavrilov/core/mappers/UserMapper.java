package ru.gavrilov.core.mappers;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import ru.gavrilov.core.users.dto.UserDTO;
import ru.gavrilov.core.users.model.User;

@Mapper(withCustom = UserCustomMapper.class, withIgnoreMissing = IgnoreMissing.ALL)
public interface UserMapper {

    UserDTO asUserDTO(User source);

    User asUser (UserDTO authorDTO);

}
