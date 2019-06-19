package com.kk.enriry;

public class Address {
    private String addressName;

    public Address(String addressName) {
        this.addressName = addressName;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressName='" + addressName + '\'' +
                '}';
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}
