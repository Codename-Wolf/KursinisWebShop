package coursework.kursiniswebshop.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@Getter
@Setter
@AllArgsConstructor

public class Subscriptions extends Product{
    private String title;
    private String description;
    private String category;
    private String developer;
    private LocalDate releaseDate;
    private String duration;
}
