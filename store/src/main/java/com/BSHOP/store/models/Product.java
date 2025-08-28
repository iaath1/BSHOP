package com.BSHOP.store.models;

import lombok.Data;

@Data
public class Product {
    
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Size size;
    private Category category;
    private String image_url;
    private Material material;
    private Color color;

    public Product() {};

    public Product(Long id, String name, String description, double price, int quantity, Size size, Category category, String image_url, Material material, Color color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.category = category;
        this.image_url = image_url;
        this.material = material;
        this.color = color;
    }
    
    public Product(String name, String description, double price, int quantity, Size size, Category category, String image_url, Material material, Color color) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.category = category;
        this.image_url = image_url;
        this.material = material;
        this.color = color;
    }
}
