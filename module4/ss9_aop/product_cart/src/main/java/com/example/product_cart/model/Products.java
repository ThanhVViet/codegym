package com.example.product_cart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String imgUrl;
    private String color;
    private double price;
    private String description;

    @OneToMany(mappedBy = "products")
    private Collection<OrdersDetail> ordersDetails;
}
