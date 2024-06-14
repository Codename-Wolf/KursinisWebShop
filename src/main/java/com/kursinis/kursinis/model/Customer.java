package com.kursinis.kursinis.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Customer extends User{
    private String cardNo;
    private String billingAddress;

    public Customer(String email, String name, String surname, String login, String password, String cardNo, String billingAddress, String isAdmin) {
        super(email, name, surname, login, password, isAdmin, "Customer");
        this.cardNo = cardNo;
        this.billingAddress = billingAddress;
    }
}
