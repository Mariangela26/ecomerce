package com.example.ecomerce.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Cart {

    private String id;
    private List<Product> products;
    private LocalDateTime lastUpdate;

    public void addProduct (Product product){
        this.products.add(product);
        this.lastUpdate = LocalDateTime.now();
    }
}
