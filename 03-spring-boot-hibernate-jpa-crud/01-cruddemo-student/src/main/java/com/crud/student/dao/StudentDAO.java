package com.crud.student.dao;

import com.crud.student.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student student);
    public Student findById(int id);
    public List<Student> findAll();
    public List<Student> findByFirstName(String firstName);
}
