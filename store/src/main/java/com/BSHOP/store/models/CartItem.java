package com.BSHOP.store.models;

import lombok.Data;

@Data
public class CartItem {
    private Long id;
    private Cart cart;
    private Product product;
    private int quantity;

    public CartItem() {}

    public CartItem(Long id, Cart cart, Product product, int quantity) {
        this.id = id;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(Cart cart, Product product, int quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }
}
