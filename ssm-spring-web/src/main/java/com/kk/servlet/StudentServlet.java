package com.kk.servlet;

import com.kk.service.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/query1")
public class StudentServlet extends HttpServlet {
    StudentServiceImpl studentService;

    //servlet初始化方法:在初始化时,获取SpringIOC容器bean对象
    @Override
    public void init() throws ServletException {
//        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-Service.xml");
        //web项目获取spring上下文对象context
        ApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        //在servlet容器中获取ioc容器bean对象
        studentService=context.getBean("studentService",StudentServiceImpl.class);
    }

    public StudentServiceImpl getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("info",studentService.getStudentById(1));
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
