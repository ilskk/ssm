package com.kk.entity;

public class Person {
    private String name;

    public void myInit(){
        name="张三丰";
        System.out.println("init...");
    }

    public void myDestroy(){
        System.out.println("destroy...");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public Person() {
        System.out.println("Person 无参");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;
}
