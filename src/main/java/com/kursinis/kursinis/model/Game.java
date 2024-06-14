package com.kursinis.kursinis.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@AllArgsConstructor

public class Game extends Product{
    public Game(String title, String description, String genrecateg, String developer, String version, LocalDate releaseDate, float price) {
        super(title,description,genrecateg,developer,version,releaseDate, price);
    }
}
