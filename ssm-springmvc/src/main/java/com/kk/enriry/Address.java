package com.kk.enriry;

public class Address {
    private String addressName;

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
