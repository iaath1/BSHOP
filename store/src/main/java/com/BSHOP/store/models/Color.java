package com.BSHOP.store.models;

import lombok.Data;

@Data
public class Color {
    private int id;
    private String name;

    public Color() {}

    public Color(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Color(String name) {
        this.name = name;
    }
}
