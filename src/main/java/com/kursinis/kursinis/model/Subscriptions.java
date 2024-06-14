package com.kursinis.kursinis.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Subscriptions extends Product {

    private String duration;

    public Subscriptions(String title, String description, String genrecateg, String developer, LocalDate releaseDate, String duration, float price) {
        super(title,description,genrecateg,developer,null,releaseDate, price);
        this.duration = duration;
    }
}
