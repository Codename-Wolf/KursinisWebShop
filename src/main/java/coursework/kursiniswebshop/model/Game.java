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
//@NoArgsConstructor
@AllArgsConstructor

public class Game extends Product{
    public Game(String title, String description, String genrecateg, String developer, String version, LocalDate releaseDate) {
        super(title,description,genrecateg,developer,version,releaseDate);
    }

//    public Game(String title) {
//    }
}
