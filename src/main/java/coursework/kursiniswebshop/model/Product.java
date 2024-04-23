package coursework.kursiniswebshop.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

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

    public String toString() {
        //veliau pridet ir ID is database
        return title;
    }

    public Product(String title, String description, String genrecateg, String developer, String version, LocalDate releaseDate) {
        this.title = title;
        this.description = description;
        this.genrecateg = genrecateg;
        this.developer = developer;
        this.version = version;
        this.releaseDate = releaseDate;
    }


    public Product(String title) {
        this.title = title;
    }
}
