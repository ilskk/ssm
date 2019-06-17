package com.kk.entity;

import java.io.Serializable;

public class Address {
    private String address;

    public Address(String address) {
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
