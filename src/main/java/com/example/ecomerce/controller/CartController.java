package com.example.ecomerce.controller;

import com.example.ecomerce.model.Cart;
import com.example.ecomerce.model.Product;
import com.example.ecomerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Cart> createCart() {
        Cart cart = cartService.createCart();
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable String id) {
        Cart cart = cartService.getCart(id);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable String id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/products")
    public Cart addProducts(@PathVariable String id, @RequestBody List<Product> products) {
        return cartService.addProductsToCart(id, products);
    }

    @GetMapping
    public ResponseEntity<Collection<Cart>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }
}
