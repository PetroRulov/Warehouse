package com.foxminded.warehouse.model.domain;

public class Catalogue extends AbstractGroup {

    public Catalogue(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name;
    }
}