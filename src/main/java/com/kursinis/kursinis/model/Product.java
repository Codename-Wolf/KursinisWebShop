package com.kursinis.kursinis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String title;
    private String description;
    private String genrecateg;
    private String developer;
    private String version;
    private LocalDate releaseDate;
    private float price;

    public String toString() {
        return title + " " + price + " €";
    }

    public Product(String title, String description, String genrecateg, String developer, String version, LocalDate releaseDate, float price) {
        this.title = title;
        this.description = description;
        this.genrecateg = genrecateg;
        this.developer = developer;
        this.version = version;
        this.releaseDate = releaseDate;
        this.price = price;
    }


    public Product(String title) {
        this.title = title;
    }
}
