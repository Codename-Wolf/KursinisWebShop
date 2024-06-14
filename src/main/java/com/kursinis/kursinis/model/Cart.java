package com.kursinis.kursinis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @PrimaryKeyJoinColumn(name = "another_id_column")

    private List<Product> productList;

    @ManyToOne
    private Customer customer;

    private String orderstate;


    private LocalDate dateCreated;

    public Cart(Customer customer) {
        this.customer = customer;
        this.dateCreated = LocalDate.now();
        this.productList = new ArrayList<>();
        this.orderstate = "NOT_PLACED";
    }

    @Override
    public String toString(){
        return this.getId() + " : " + this.getOrderstate();
    }

    public void addProduct(Product product) {
        if(!productList.contains(product))
        {
            productList.add(product);
        }
    }
}