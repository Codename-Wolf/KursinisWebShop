package coursework.kursiniswebshop.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@Getter
@Setter
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor

public abstract class User {
    //Man reikes veliau, kai dirbsiu su db
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String email;
    protected String name;
    protected String surname;
    protected String login;
    protected String password;
    protected String acctype;
    protected LocalDate dateCreated;
    protected LocalDate dateModified;

    public User(String name, String surname, String login, String password) {
        //this.email = email;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        //this.acctype = acctype;
        //dateCreated, dateModified ir ID nereikia nes sitie duomenys bus is duomenu bazes
    }
}
