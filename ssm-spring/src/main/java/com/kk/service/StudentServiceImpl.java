package com.kk.service;

import com.kk.dao.StudentDaoImpl;
import com.kk.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired //byType
//    @Qualifier("") byName
    private StudentDaoImpl studentDaoImpl;

//    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addStudent(Student student) {
        //if(student==null)
        //增加其他逻辑...
        studentDaoImpl.addStudent(student);
    }

    @Override
    public String toString() {
        return "StudentServiceImpl{" +
                "studentDaoImpl=" + studentDaoImpl +
                '}';
    }

}