package com.BSHOP.store.models;

import java.util.List;

import lombok.Data;

@Data
public class Cart {

    private Long id;
    private Long user_id;
    private List<CartItem> cartItems;
    
    public Cart() {}

    public Cart(Long id, Long user_id, List<CartItem> cartItems) {
        this.id = id;
        this.user_id = user_id;
        this.cartItems = cartItems;
    }

    public Cart(Long user_id, List<CartItem> cartItems) {
        this.user_id = user_id;
        this.cartItems = cartItems;
    }
}
