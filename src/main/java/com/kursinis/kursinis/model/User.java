package com.kursinis.kursinis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String email;
    protected String name;
    protected String surname;
    protected String login;
    protected String password;
    protected String acctype;
    protected LocalDate dateCreated;
    protected LocalDate dateModified;
    protected String isAdmin;

    public User(String email, String name, String surname, String login, String password, String isAdmin, String acctype) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
        this.acctype = acctype;
    }
}
