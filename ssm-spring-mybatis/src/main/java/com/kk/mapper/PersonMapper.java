package com.kk.mapper;

import com.kk.entity.Person;

import java.util.List;

public interface PersonMapper {

    List<Person> selectPersonAll();

    Person selectPersonById(Integer id);

    void insertPerson(Person person);

    void updatePersonById(Person person);

    void deleteById(Integer id);

}
