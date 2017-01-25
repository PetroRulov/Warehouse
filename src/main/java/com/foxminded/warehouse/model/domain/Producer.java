package com.foxminded.warehouse.model.domain;

/**
 * Created by prulov on 23.01.2017.
 */
public class Producer {

    private int id;
    private String name;

    public Producer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Producer{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
