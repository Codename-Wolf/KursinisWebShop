package coursework.kursiniswebshop.model;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
//@AllArgsConstructor

public class Software extends Product {
    public Software(String title, String description, String genrecateg, String developer, String version, LocalDate releaseDate) {
        super(title,description,genrecateg,developer,version,releaseDate);
    }
}
