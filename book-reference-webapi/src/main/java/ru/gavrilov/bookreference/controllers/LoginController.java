package ru.gavrilov.bookreference.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gavrilov.core.logins.service.LoginService;
import ru.gavrilov.core.mappers.MapperFactory;
import ru.gavrilov.core.mappers.UserMapper;
import ru.gavrilov.core.users.dto.UserDTO;
import ru.gavrilov.core.users.model.User;

@RestController
@RequestMapping("api/logins")
public class LoginController {
    private LoginService loginService;
    private static  final UserMapper userMapper = MapperFactory.createMapper(UserMapper.class);

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public ResponseEntity<UserDTO> authorization(@RequestParam(name="login") String login,
                                           @RequestParam(name="password") String password){
        User user = loginService.getUser(login,password);
        UserDTO userDto = userMapper.asUserDTO(user);
        return ResponseEntity.ok(userDto);
    }
}
