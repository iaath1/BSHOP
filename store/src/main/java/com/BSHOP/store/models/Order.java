package com.BSHOP.store.models;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Order {
    
    private Long id;
    private User user;
    private Status status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private double total_price;
    private List<OrderItem> orderItems;

    public Order() {}

    public Order(Long id, User user, Status status, LocalDateTime created_at, LocalDateTime updated_at, double total_price, List<OrderItem> orderItems) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.total_price = total_price;
        this.orderItems = orderItems;
    }

    public Order(User user, Status status, LocalDateTime created_at, LocalDateTime updated_at, double total_price, List<OrderItem> orderItems) {
        this.user = user;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.total_price = total_price;
        this.orderItems = orderItems;
    }
}
