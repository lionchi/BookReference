package ru.gavrilov.bookreference.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gavrilov.core.mappers.MapperFactory;
import ru.gavrilov.core.mappers.UserMapper;
import ru.gavrilov.core.users.dto.UserDTO;
import ru.gavrilov.core.users.model.User;
import ru.gavrilov.core.users.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    private static  final UserMapper userMapper = MapperFactory.createMapper(UserMapper.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUser();
        List<UserDTO> userDtoList = users.stream()
                .map((userMapper::asUserDTO))
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDtoList);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
        User saveUser = userService.createUser(user);
        UserDTO saveUserDto = userMapper.asUserDTO(saveUser);
        return ResponseEntity.ok(saveUserDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long userId) {
        User user = userService.getUserById(userId);
        UserDTO userDto = userMapper.asUserDTO(user);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/save/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable(value = "id") Long userId,
                                           @Valid @RequestBody UserDTO userDetails) {
        User updatedUser = userService.updateUser(userId, userDetails);
        UserDTO saveUpdateUserDto = userMapper.asUserDTO(updatedUser);
        return ResponseEntity.ok(saveUpdateUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
