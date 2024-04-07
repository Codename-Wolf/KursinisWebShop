package coursework.kursiniswebshop.model;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Setter
public class Product {
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
}
