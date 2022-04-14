package ru.yandex.practicum.catsgram.exceptions;

import java.io.IOException;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
