import com.kk.service.AdviceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    static ApplicationContext applicationContext=
            new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args){
              AdviceService service=applicationContext.getBean("adviceService", AdviceService.class);
//              service.service();
        try {
            service.demo("param-2");
        } catch (ArithmeticException e) {
//            e.printStackTrace();
        }
    }

}
