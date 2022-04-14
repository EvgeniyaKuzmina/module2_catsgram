package ru.yandex.practicum.catsgram.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exceptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exceptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    private final HashMap<String, User> users = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users")
    public List<User> findAll() {
        log.debug("Количество пользователей в текущий момент {}", users.size());
        return new ArrayList<>(users.values());
    }

    @PostMapping(value = "/user")
    public void create(@RequestBody User user) throws UserAlreadyExistException, InvalidEmailException {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Не указан email адрес");
        }
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователь с указанным адресом электронной почты уже есть");
        }
        log.debug("Добавлен пользователь {}", user);
        users.put(user.getEmail(), user);
    }

    @PutMapping(value = "/user")
    public void update(@RequestBody User user) throws InvalidEmailException{
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Не указан email адрес");
        }
        if (users.containsKey(user.getEmail())) {
            log.debug("Обновлены данные пользователя {}", user);
            users.get(user.getEmail()).updateUser(user.getNickname(), user.getBirthdate());
        } else {
            log.debug("Добавлен пользователь {}", user);
            users.put(user.getEmail(), user);
        }
    }
}
