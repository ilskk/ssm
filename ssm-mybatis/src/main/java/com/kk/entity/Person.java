package com.kk.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private boolean sex;
    transient private Address address;
    transient private PersonCard personCard;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address=" + address +
                ", personCard=" + personCard +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person(Integer id) {
        this.id = id;
    }

    public PersonCard getPersonCard() {
        return personCard;
    }

    public void setPersonCard(PersonCard personCard) {
        this.personCard = personCard;
    }

    public Person() {
    }

    public Person(Integer id, String name, Integer age, boolean sex, Address address, PersonCard personCard) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.personCard = personCard;
    }
}
