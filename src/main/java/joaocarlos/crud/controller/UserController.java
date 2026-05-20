package joaocarlos.crud.controller;


import joaocarlos.crud.dto.UserCreateDto;
import joaocarlos.crud.dto.UserDto;
import joaocarlos.crud.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping // Irá requisitar um usuário
    UserDto create(@RequestBody UserCreateDto user) {
        return userService.create(user);
    }

    @PutMapping("{id}") // Irá requisitar um usuário
    UserDto update(@PathVariable Long id, @RequestBody UserCreateDto user) {
        return userService.update(id, user);
    }

    @GetMapping // Irá retornar
    List<UserDto> list() {
        return userService.list();}

    @DeleteMapping("{id}") // Irá requisitar um id como variável
    void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }


}
