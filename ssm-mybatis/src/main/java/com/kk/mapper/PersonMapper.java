package com.kk.mapper;

import com.kk.entity.IDs;
import com.kk.entity.Person;
import com.kk.entity.PersonExtension;
import com.kk.entity.PersonLevel;

import java.util.List;
import java.util.Map;

public interface PersonMapper {

    List<Person> queryPersonByOO_lazyload();

    PersonLevel queryPersonLevelOO(Integer id);

    Person queryPersonByOO2(Integer id);

    PersonExtension queryPersonByOO(Integer id);

    List<Person> queryPeronByObjectArray(Person[] arr);

    List<Person> queryPeronByList(List<Integer> list);

    List<Person> queryPeronByArray(int[] arr);

    List<Person> queryPeronByIDs(IDs iDs);

    Person queryPersonByNameAndAge(Person person);

    List<Map<String,Object>> selectPersonAllIsMap();

    Integer selectPersonCount();

    void queryDate(Map<String, Object> map);

    void removePersonById(Integer id);

    List<Person> selectHashMap(Map<String, Object> map);

    Person selectConverter(Integer id);

    void insertConverter(Person person);

    Person selectById(Integer id);

    Person selectByName(String name);

    List<Person> selectByPerson(Person person);

    List<Person> selectByNameOrAge(Person person);

    List<Person> selectOrderByColumn(String column);

    List<Person> selectPersonAll();

    void insertPerson(Person person);

    void updatePersonById(Person person);

    void deleteById(Integer id);

}
