package com.example.ecomerce.service;

import com.example.ecomerce.model.Cart;
import com.example.ecomerce.model.Product;
import com.example.ecomerce.repository.CartRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart createCart() {
        return cartRepository.createCart();
    }

    public Cart getCart(String id) {
        return cartRepository.getCart(id);
    }

    public void deleteCart(String id) {
        cartRepository.deleteCart(id);
    }

    public Cart addProductsToCart(String id, List<Product> products) {
        Cart cart = cartRepository.getCart(id);
        if (cart != null) {
            cart.getProducts().addAll(products);
            cart.updateLastAccessed();
        }
        return cart;
    }

    public Collection<Cart> getAllCarts() {
        return cartRepository.getAllCarts();
    }


    @Scheduled(fixedRate = 60000)
    public void removeInactiveCarts() {
        Collection<Cart> carts = cartRepository.getAllCarts();
        LocalDateTime now = LocalDateTime.now();

        carts.stream()
                .filter(cart -> Duration.between(cart.getLastUpdate(), now).toMinutes() >= 10)
                .map(Cart::getId)
                .forEach(cartRepository::deleteCart);
    }
}
