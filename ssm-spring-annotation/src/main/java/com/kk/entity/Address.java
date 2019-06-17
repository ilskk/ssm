package com.kk.entity;

public class Address {
    private String name;



    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
