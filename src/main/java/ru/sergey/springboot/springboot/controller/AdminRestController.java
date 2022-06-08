package ru.sergey.springboot.springboot.controller;

import org.springframework.web.bind.annotation.*;
import ru.sergey.springboot.springboot.entities.User;
import ru.sergey.springboot.springboot.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.allUser();
    }

    @GetMapping("users/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.removeUserById(id);
    }
}
