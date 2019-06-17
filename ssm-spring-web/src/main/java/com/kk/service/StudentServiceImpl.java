package com.kk.service;

import com.kk.dao.StudentDaoImpl;

public class StudentServiceImpl implements StudentService {

    private StudentDaoImpl studentDao;

    public StudentDaoImpl getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public String getStudentById(Integer id) {
         return studentDao.getStudentById(id);
    }
}
