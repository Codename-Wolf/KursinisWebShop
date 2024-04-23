package coursework.kursiniswebshop.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@Getter
@Setter
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor

public final class Manager extends User {
    private boolean isAdmin;

    public Manager(String name, String surname, String login, String password, boolean isAdmin) {
        super(name, surname, login, password);
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "isAdmin=" + isAdmin +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}