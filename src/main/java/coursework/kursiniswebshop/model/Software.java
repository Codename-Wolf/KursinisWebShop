package coursework.kursiniswebshop.model;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Setter

public class Software extends Product {
    public Software(String title, String description, String genrecateg, String developer, String version, LocalDate releaseDate) {
        super(title,description,genrecateg,developer,version,releaseDate);
    }
}
