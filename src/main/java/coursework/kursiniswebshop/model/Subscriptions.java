package coursework.kursiniswebshop.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Subscriptions extends Product {

    private String duration;

    public Subscriptions(String title, String description, String genrecateg, String developer, LocalDate releaseDate, String duration) {
        super(title,description,genrecateg,developer,null,releaseDate);
        this.duration = duration;
    }
}
