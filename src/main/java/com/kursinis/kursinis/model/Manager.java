package com.kursinis.kursinis.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor

public final class Manager extends User {

    public Manager(String email, String name, String surname, String login, String password, String isAdmin) {
        super(email, name, surname, login, password, isAdmin, "Manager");
    }

}