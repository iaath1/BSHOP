package com.BSHOP.store.models;

import lombok.Data;

@Data
public class Size {
    private int id;
    private String name;

    public Size() {};

    public Size(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Size(String name) {
        this.name = name;
    }
}
