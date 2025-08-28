package com.BSHOP.store.models;

import lombok.Data;

@Data
public class Material {
    private int id;
    private String name;

    public Material() {};

    public Material(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Material(String name) {
        this.name = name;
    }
}
