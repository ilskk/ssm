package com.kk.factory;

import com.kk.newinstance.HtmlCourse;
import com.kk.newinstance.ICourse;
import com.kk.newinstance.JavaCourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 课程工厂
 */
public class CourseFactory {

    static ApplicationContext applicationContext=
            new ClassPathXmlApplicationContext("applicationContext.xml");

    //根据名字获取课程
    public static ICourse getCourse(String name){
        if(name.equals("java")){
            return applicationContext.getBean("javaCourse",JavaCourse.class); //new->从ioc容器获取
        }else {
            return applicationContext.getBean("htmlCourse",HtmlCourse.class);
        }
    }

}
