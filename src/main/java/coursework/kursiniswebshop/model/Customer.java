package coursework.kursiniswebshop.model;


import java.time.LocalDate;

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

public class Customer extends User{
    private String cardNo;
    private String deliveryAddress;
    private String billingAddress;
    private LocalDate birthDate;

    public Customer(String name, String surname, String login, String password, String cardNo, String deliveryAddress, String billingAddress, LocalDate birthDate) {
        super(name, surname, login, password);
        this.cardNo = cardNo;
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
        this.birthDate = birthDate;
    }
}
