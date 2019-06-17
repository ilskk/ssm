import com.kk.entity.CollectionType;
import com.kk.entity.Course;
import com.kk.entity.Student;
import com.kk.factory.CourseFactory;
import com.kk.newinstance.HtmlCourse;
import com.kk.newinstance.ICourse;
import com.kk.service.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1.0
 */
public class Test {

    //spring上下文对象:ApplicationContext
    static ApplicationContext applicationContext=
            new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args){

//        Student student=new Student();
//        student.setStuNo(1);
//        student.setStuName("张三");
//        student.setSetAge(33);

        //从springIOC容器中获取一个名为student,类型为Student.class的对象
        Student student=applicationContext.getBean("student",Student.class);
//        System.out.println(student);

        //1,new
        //2,对象属性的复制

//        studyCourse();
//        studyCourseWithFacotry();
//        studyCourseWithIOC();
//        testDi();
//        collectionDemo();
        applicationContext.getBean("studentServiceImpl", StudentServiceImpl.class).addStudent(null);
    }

    static void collectionDemo(){
        CollectionType collectionType=applicationContext.getBean("collectionType",CollectionType.class);
        System.out.println(collectionType);

    }

    static void testDi(){
        Course course=applicationContext.getBean("course1",Course.class);
        System.out.println(course);
    }

    static void studyCourseWithFacotry(){
        ICourse course1= CourseFactory.getCourse("java");
        ICourse course2= CourseFactory.getCourse("html");

        new Student().stduy(course1);
    }

    static void studyCourseWithIOC(){
        Student student=applicationContext.getBean("student",Student.class);
        student.stduy(applicationContext.getBean("htmlCourse", HtmlCourse.class));
    }

    static void studyCourse(){
        Student student=new Student();
        student.studyJava();
        student.studyHtml();
    }

}
