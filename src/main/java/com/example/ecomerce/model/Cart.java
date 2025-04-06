package com.example.ecomerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private String id;
    private LocalDateTime lastUpdate;
    private List<Product> products;


    public Cart(String id) {
        this.id = id;
        this.lastUpdate = LocalDateTime.now();
        this.products = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(List<Product> products) {
        this.products = products;
    }

    public void updateLastAccessed() {
        this.lastUpdate = LocalDateTime.now();
    }
}
