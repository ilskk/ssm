import com.kk.entity.Person;
import com.kk.service.PersonServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {

    @Autowired
    PersonServiceImpl service;

    @org.junit.Test
    public void test(){
        List<Person> list=new ArrayList<>();
        list=service.selectPersonAll();
        for (Person person : list) {
            System.out.println(person);
        }

//        service.insertPerson(new Person(0,"小明",15));
//        service.updatePersonById(new Person(8,"小红",16));
//        service.deleteById(8);
    }
}
