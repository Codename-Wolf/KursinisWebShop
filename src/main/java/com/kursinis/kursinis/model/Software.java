package com.kursinis.kursinis.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Software extends Product {
    public Software(String title, String description, String genrecateg, String developer, String version, LocalDate releaseDate, float price) {
        super(title,description,genrecateg,developer,version,releaseDate, price);
    }
}
