package coursework.kursiniswebshop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Shop {
    private List<User> systemUsers;
    private List<Product> products;

    public Shop() {
        this.systemUsers = new ArrayList<>();
        this.products = new ArrayList<>();
    }
}
