package com.BSHOP.store.models;

import java.util.List;

import lombok.Data;

@Data
public class User {
    
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private Role role = Role.CUSTOMER;
    private String address;

    private List<Order> orders;
    private Cart cart;

    public User() {}

    
    public User(Long id, String name, String surname, String email, String phone, String password, Cart cart, String address, Role role, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.cart = cart;
        this.address = address;
        this.role = role;
        this.orders = orders;
    }

    public User(String name, String surname, String email, String phone, String password, Cart cart, String address, Role role, List<Order> orders) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.cart = cart;
        this.address = address;
        this.role = role;
        this.orders = orders;
    }

}
