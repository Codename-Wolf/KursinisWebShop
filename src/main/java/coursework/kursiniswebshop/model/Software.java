package coursework.kursiniswebshop.model;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor

public class Software extends Product{
    private String title;
    private String description;
    private String category;
    private String developer;
    private String version;
    private LocalDate releaseDate;
}
