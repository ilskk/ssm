package com.kk.service;

import com.kk.entity.Person;
import com.kk.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper mapper;

    @Override
    public List<Person> selectPersonAll() {
        return mapper.selectPersonAll();
    }

    @Override
    public Person selectPersonById(Integer id) {
        return mapper.selectPersonById(id);
    }

    @Override
    public void insertPerson(Person person) {
        mapper.insertPerson(person);
    }

    @Override
    public void updatePersonById(Person person) {
        mapper.updatePersonById(person);
    }

    @Override
    public void deleteById(Integer id) {
        mapper.deleteById(id);
    }
}
