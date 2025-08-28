package com.BSHOP.store.models;

import lombok.Data;

@Data
public class OrderItem {
    private Long id;
    private Order order;
    private Product product;
    private int quantity;
    private double price;

    public OrderItem() {};

    public OrderItem(Long id, Order order, Product product, int quantity, double price) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem(Order order, Product product, int quantity, double price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
