package ru.yandex.practicum.catsgram.models;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private String email;
    private String nickname;
    private LocalDate birthdate;


    public User(String email, String nickname, LocalDate birthdate) {
        this.email = email;
        this.nickname = nickname;
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void updateUser(String nickname, LocalDate birthdate) {
        this.nickname = nickname;
        this.birthdate = birthdate;

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}



