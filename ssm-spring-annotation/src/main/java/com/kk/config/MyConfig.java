package com.kk.config;

import com.kk.entity.Import.Apple;
import com.kk.entity.Import.Banana;
import com.kk.entity.Import.Fruit;
import com.kk.entity.condition.*;
import com.kk.entity.Address;
import com.kk.entity.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * 加入bean的方法:
 *      三层组件:@Service,@Controller,@Repository
 *      非三层组件:(1)@Bean+返回值(2)@Import(3)@FactoryBean
 *
 */
/*@ComponentScan(value = "com.kk.*",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value ={ Service.class, Repository.class} )}
        ,useDefaultFilters = true)*/
//type = FilterType.CUSTOM:自定义排除规则
//@ComponentScan(value = "com.kk.*",excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,value = MyFilter.class)})
//@ComponentScan("com.kk.lifecycle")
@ComponentScan("com.kk.*")
@Configuration
//@Import({Apple.class, Banana.class, Orange.class})
//@Import({MyImportSelector.class,Orange.class})
@Import(MyImportBeanDefinitionRegistrar.class)
public class MyConfig {

//    @Bean(initMethod = "myInit",destroyMethod = "myDestroy") // id="myPerson"
//    @Scope("prototype") //singleton(默认):容器初始化产生对象,prototype:getBean()才产生对象
    @Bean
//    @Lazy //singleton:getBean()才产生对象(延迟加载)
    public Person myPerson(/*@Autowired*/ Address address){
        Person person=new Person();
        person.setName("张三");
        person.setAddress(address);
        return person;
    }

    @Bean
    public Address myAddress(){
        Address address=new Address();
        address.setName("中国人");
        return address;
    }

//    @Bean
//    @Conditional(OilCarCondition.class) //条件注解(在某些条件下加入IOC容器)
//    public Car oilCar(){return new OilCar();}
//
//    @Conditional(EnergyCarCondition.class)
//    @Bean
//    public Car energyCar(){return new EnergyCar();}

    @Bean
    public FactoryBean<Apple> myFactoryBean(){
        return new MyFactoryBean();
    }

    @Profile("myApple")
    @Bean
    public Fruit apple(){return new Apple();}

    @Profile("myBanana")
    @Bean
    public Fruit banana(){return new Banana();}
}
