package com.example.ecomerce.repository;

import com.example.ecomerce.model.Cart;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class CartRepository {

    private final Map<String, Cart> cartStorage = new HashMap<>();

    public Cart createCart() {
        String id = UUID.randomUUID().toString();
        Cart cart = new Cart(id);
        cartStorage.put(id, cart);
        return cart;
    }

    public void deleteCart(String id) {
        cartStorage.remove(id);
    }

    public Collection<Cart> getAllCarts() {
        return cartStorage.values();
    }

    public Cart getCart(String id) {

        return cartStorage.get(id);
    }

}
