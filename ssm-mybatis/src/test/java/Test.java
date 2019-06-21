import com.kk.entity.Person;
import com.kk.entity.PersonCard;
import com.kk.mapper.PersonMapper;
import com.kk.util.SqlSessionUtils;
import com.sun.glass.ui.DelayedCallback;
import net.sf.ehcache.Ehcache;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.caches.ehcache.EhcacheCache;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis初级
 */
public class Test {

    static SqlSession session= SqlSessionUtils.getSqlSession();

    static PersonMapper mapper=session.getMapper(PersonMapper.class);

    public static void main(String[] args)throws Exception{

//        Person person= session.selectOne("a.b.c.personMapper.selectById",1);
//        System.out.println(person);

//        List<Person> list=session.selectList("a.b.c.personMapper.selectPersonAll");
//        for (Person person : list) {
//            System.out.println(person);
//        }

//        Person person=new Person(2,"星期六",10);
//
//        if(session.insert("a.b.c.personMapper.deleteById",5)==1){
//            System.out.println("修改成功!");
//            session.commit();
//        }else {
//            System.out.println("修改失败");
//        }
//
//        session.close();

        //mapper();//
        Object o=new Integer(1);
        System.out.println(o);

//        cache();

//        generator();
        System.exit(0);
    }

    static void generator()throws Exception{

        File file=new File("src\\main\\resources\\Generator.xml");
        System.out.println(file.exists());
        List<String> warnings=new ArrayList<>();

        Configuration config=new ConfigurationParser(warnings).parseConfiguration(file);

        DefaultShellCallback callback=new DefaultShellCallback(true);

        //逆向工程核心类
        MyBatisGenerator generator=new MyBatisGenerator(config,callback,warnings);
        generator.generate(null);
    }

     static void cache() {
        /*
        mybatis一级缓存(默认开启):如果用同样的sqlSession执行相同的sql语句,
        则会在第一次查询时,去调用数据库进行查询,然后在将查询结果放入缓存中,
        后续再执行相同的sql语句,则不调用数据库,直接从缓存中取数据.
        clearCache();:清除缓存中的数据
         */
//        mapper.selectPersonCount();
//        session.clearCache();
//        mapper.selectPersonCount();

         /**
          * 二级缓存(默认不开启):同一个XXXmapper.xml产生的XXXmapper对象
          * 清理缓存与一级一样
          */
         PersonMapper mapper1=mapper;

         SqlSession session2= SqlSessionUtils.getSqlSession();
         PersonMapper mapper2=session2.getMapper(PersonMapper.class);

         mapper1.selectById(1);
         session.close(); //进行缓存的时刻

         mapper2.selectById(1);
         session2.close();
    }

    static void mapper(){

//        Person p=new Person();
//        p.setAge(4444);
//        p.setName("k");
//        p.setAddress(new Address("火星"));
//
//        List<Person> list=mapper.selectByPerson(p);
//        for (Person person : list) {
//            System.out.println(person);
//        }

//        Map<String,Object> map=new HashMap();
//        map.put("name","火星人");
//        map.put("age","4444");
//        System.out.println(mapper.selectHashMap(map));

//        Map<String,Object> map=new HashMap();
//        //获取存储过程的返回值
//        mapper.queryDate(map);
//        String date=(String) map.get("date");
//        System.out.println(date);

//        System.out.println(mapper.selectPersonCount());

//        System.out.println(mapper.selectById(6));

//        List<Map<String,Object>> list=mapper.selectPersonAllIsMap();
//        for (Map<String, Object> map : list) {
//            System.out.println(map);
//        }

//        mapper.removePersonById(1);

//        System.out.println(mapper.selectById(7));

//        System.out.println(mapper.selectByName("王五"));

//        mapper.insertPerson(new Person(null,"什么鬼",0));

//        mapper.updatePersonById(new Person(4,"米斯达",4444));

//        mapper.deleteById(1);

//        System.out.println(mapper.selectConverter(7));

//        mapper.insertConverter(new Person(null,"王五",35,true));

//        Person p=new Person();
////        p.setName("火星异种");
//        p.setAge(1);
//        System.out.println(mapper.queryPersonByNameAndAge(p));

//        IDs iDs=new IDs();
//        List<Integer> list=new ArrayList();
//        list.add(6);
//        list.add(7);
//        iDs.setIds(list);
//
//        System.out.println(mapper.queryPeronByIDs(iDs));

//        int[] arr={2,4,5};
//        System.out.println(mapper.queryPeronByArray(arr));

//        List<Integer> list=new ArrayList();
//        list.add(2);
//        list.add(5);
//        List<Person> list1=mapper.queryPeronByList(list);
//        System.out.println(list1);

//        Person[] arr={
//                new Person(4),
//                new Person(6)
//        };
//        mapper.queryPeronByObjectArray(arr);

        List<Person> list=mapper.queryPersonByOO_lazyload();

        for (Person person : list) {
            System.out.println(person.getId()+","+person.getName()+","+person.getAge());

            PersonCard personCard=person.getPersonCard();
            System.out.println(personCard);
        }

//        System.out.println(mapper.queryPersonByOO2(2));

//        System.out.println(mapper.queryPersonLevelOO(2));

        session.commit();
    }

}
