package com.spring.jpa_advanced.dao;

import com.spring.jpa_advanced.entity.Course;
import com.spring.jpa_advanced.entity.Instructor;
import com.spring.jpa_advanced.entity.InstructorDetail;
import com.spring.jpa_advanced.entity.Student;

import java.util.List;

public interface AppDAO {
    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteById(int id);
    public InstructorDetail findInstructorDetailById(int id);
    public void deleteInstructorDetailById(int id);
    public List<Instructor> findAll();
    public List<Course> findCoursesByInstructorId(int id);
    public Instructor findInstructorWithJoin(int id);
    public Instructor update(Instructor instructor);
    public Course update(Course course);
    public Course findCourseById(int id);
    public void deleteCourseById(int id);
    public void saveCourse(Course course);
    public Course getCourseWithReviewsById(int id);
    public Course getCourseWithStudentsById(int id);
    public Student getStudentWithCourseById(int id);
    public void saveStudent(Student student);
    public void deleteStudent(int id);
}
