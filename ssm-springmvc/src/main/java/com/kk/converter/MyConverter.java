package com.kk.converter;

import com.kk.enriry.Person;
import org.springframework.core.convert.converter.Converter;

public class MyConverter implements Converter<String, Person> {
    @Override
    public Person convert(String s) {
        //s接收前端传来的String:0-zero
        String[] strings=s.split("-");

        Person p=new Person();
        p.setId(Integer.parseInt(strings[0]));
        p.setName(strings[1]);

        return p;
    }
}
