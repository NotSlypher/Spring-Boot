package com.spring.jpa_advanced.dao;

import com.spring.jpa_advanced.entity.Instructor;
import com.spring.jpa_advanced.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteById(int id);
    public InstructorDetail findInstructorDetailById(int id);
    public void deleteInstructorDetailById(int id);
    public List<Instructor> findAll();
}
