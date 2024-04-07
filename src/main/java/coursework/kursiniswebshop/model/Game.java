package coursework.kursiniswebshop.model;

import java.time.LocalDate;

import lombok.Setter;
import lombok.Getter;
@Getter
@Setter

public final class Game extends Product{
    public Game(String title, String description, String genrecateg, String developer, String version, LocalDate releaseDate) {
        super(title,description,genrecateg,developer,version,releaseDate);
    }
}
