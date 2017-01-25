package com.foxminded.warehouse.model.domain;

public class Group extends AbstractGroup {

    private int id;


    public Group(String name, int id) {
        super(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ", " + name + ":";
    }
}
