package com.crud.student;

import com.crud.student.dao.StudentDAO;
import com.crud.student.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 students");
		Student student1 = new Student("Jeet", "Gupta", "jeet@gmail.com");
		Student student2 = new Student("Jyoti", "Gupta", "jyoti@gmail.com");
		Student student3 = new Student("Asmi", "Gupta", "asmi@gmail.com");

		System.out.println("Saving students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating a student");
		Student student = new Student("Ayush", "Gupta", "ayushgupta6719@gmail.com");

		System.out.println("Saving student into DB");
		studentDAO.save(student);

		System.out.println("student has id " + student.getId());
	}
}
