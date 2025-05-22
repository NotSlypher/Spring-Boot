package com.crud.student;

import com.crud.student.dao.StudentDAO;
import com.crud.student.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//			readStudent(studentDAO);
//			findAll(studentDAO);
//			queryByFirstName(studentDAO);
//			updateFirstName(studentDAO);
//			deleteById(studentDAO);
//			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all rows");
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("rows deleted " + rowsDeleted);
	}

	private void deleteById(StudentDAO studentDAO) {
		int id = 3;
		System.out.println("deleting student with id " + id);

		studentDAO.delete(id);
		System.out.println("Student deleted");
	}

	private void updateFirstName(StudentDAO studentDAO) {
		int id = 3;
		Student student = studentDAO.findById(id);
		System.out.println("updating student " + student);

		student.setFirstName("Asmita");
		studentDAO.update(student);
		System.out.println("updated student " + student);
	}

	private void queryByFirstName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByFirstName("Ayush");
		for(Student student: students){
			System.out.println(student);
		}
	}

	private void findAll(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(Student student: students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("creating student");
		Student student = new Student("Ayush", "Gupta", "ayush@gmail.com");

		System.out.println("saving student");
		studentDAO.save(student);

		int id = student.getId();
		System.out.println("finding student with id " + id);
		student = studentDAO.findById(id);
		System.out.println("found student with id " + id);
		System.out.println(student);
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
