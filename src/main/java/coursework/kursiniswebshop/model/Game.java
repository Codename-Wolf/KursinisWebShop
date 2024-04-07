package coursework.kursiniswebshop.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@Getter
@Setter
@AllArgsConstructor

public class Game extends Product{
    private String title;
    private String description;
    private String genre;
    private String developer;
    private String version;
    private LocalDate releaseDate;



}
