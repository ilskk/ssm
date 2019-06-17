package com.kk.dao;

import com.kk.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {
    public void addStudent(Student student) {
        System.out.println("增加学生");
    }
}
