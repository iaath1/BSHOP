package com.BSHOP.store.models;

import java.util.List;

import lombok.Data;

@Data
public class Category {

    private int id;
    private String name;
    private String description;

    private List<Product> products;

    public Category() {}
    
    public Category(int id, String name, String description, List<Product> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
    }

    public Category(String name, String description, List<Product> products) {
        this.name = name;
        this.description = description;
        this.products = products;
    }
    
}
