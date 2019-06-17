package com.kk.service;

import com.kk.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class PersonService {

//    @Autowired(required = false) //从IOC容器寻找类型相同的bean
//    @Qualifier("personDaoImpl1") //根据名字寻找相同的bean
//    @Resource //默认根据名字
    @Inject //默认根据类型
    private PersonDao personDao;

//    @Autowired
//    public PersonService(PersonDao personDao) {
//        this.personDao = personDao;
//    }

    public PersonDao getPersonDao() {
        return personDao;
    }

//    @Autowired
    public void setPersonDao(PersonDao personDao) {
        System.out.println("set()...");
        this.personDao = personDao;
    }

    public void service(){
        System.out.println(personDao);
    }

}
