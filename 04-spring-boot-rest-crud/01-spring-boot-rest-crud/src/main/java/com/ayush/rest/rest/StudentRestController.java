package com.ayush.rest.rest;

import com.ayush.rest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    private void loadStudents(){
        students = new ArrayList<>();
        students.add(new Student("Ayush", "Gupta"));
        students.add(new Student("Jyoti", "Gupta"));
        students.add(new Student("Jeet", "Gupta"));
    }

    @GetMapping("/students")
    public List<Student> students(){
        return  students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if(studentId >= students.size() || studentId < 0)
            throw new StudentNotFoundException("student id is invalid " + studentId);
        return students.get(studentId);
    }
}
