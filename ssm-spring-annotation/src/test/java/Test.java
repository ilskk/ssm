import com.kk.config.MyConfig;
import com.kk.config.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Test {

    public static void main(String[] args){

        //XML形式配置
//       Person person=new ClassPathXmlApplicationContext("applicationContext.xml").
//                getBean("person",Person.class);
//        System.out.println(person);

        annotation();
    }

    static void annotation(){
        //注解配置
        ApplicationContext context=
                new AnnotationConfigApplicationContext();

        ConfigurableEnvironment environment=(ConfigurableEnvironment)context.getEnvironment();
        environment.setActiveProfiles("myBanana");

        //保存点
        ((AnnotationConfigApplicationContext) context).register(MyConfig.class);
        ((AnnotationConfigApplicationContext) context).refresh();

//        Object o1=context.getBean("apple");
        Object o2=context.getBean("banana"); //-Dspring.profiles.active=myBanana
//        System.out.println(o1);
        System.out.println(o2);

//        System.out.println(context+"11111111111111111");
//        for (String name:context.getBeanDefinitionNames()){
//            System.out.println(name);
//        }

//        Person p1=context.getBean("myPerson",Person.class);
//        Person p2=context.getBean("myPerson",Person.class);
//        System.out.println(p1==p2?"单例":"多例");

//        System.out.println(context.getBean("myFactoryBean")); //Apple
//        System.out.println(context.getBean("&myFactoryBean")); //MyFactoryBean-&:用于区分bean类型

//        Person person=context.getBean("myPerson",Person.class);
//        System.out.println(person);

//        Myconverter myconverter=context.getBean("myconverter",Myconverter.class);
//        myconverter.converter();

//        ((AnnotationConfigApplicationContext) context).close()
//
//        PersonService personService=context.getBean("personService",PersonService.class);
//        personService.service();

//        System.out.println(context.getBean("myPerson", Person.class));

        //自定义事件并发布
//        context.publishEvent(new ApplicationEvent("My Event!") {
//        });
        context.publishEvent(new MyEvent("自定义事件!!!"));

        ((AnnotationConfigApplicationContext) context).close();
    }

}
