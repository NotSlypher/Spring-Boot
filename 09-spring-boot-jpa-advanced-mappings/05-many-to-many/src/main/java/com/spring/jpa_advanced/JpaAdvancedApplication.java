package com.spring.jpa_advanced;

import com.spring.jpa_advanced.dao.AppDAO;
import com.spring.jpa_advanced.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaAdvancedApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaAdvancedApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			CreateStudentAndCourse(appDAO);
//			FindCourseAndStudentsById(appDAO);
//			FindStudentAndCoursesById(appDAO);
//			CreateCourseAndStudent(appDAO);
//			DeleteCourse(appDAO);
			DeleteStudent(appDAO);
		};
	}

	private void DeleteStudent(AppDAO appDAO) {
		int id = 2;
		System.out.println("deleting student with id " + id);
		appDAO.deleteStudent(id);
		System.out.println("done");
	}

	private void CreateCourseAndStudent(AppDAO appDAO) {
		int id = 2;
		Student student = appDAO.getStudentWithCourseById(id);

		System.out.println("adding courses to student " + student);

		student.addCourse(new Course("mining"));
		student.addCourse(new Course("Unit testing"));

		appDAO.saveStudent(student);

		System.out.println("saved student " + student);
		System.out.println("associated courses are " + student.getCourses());
	}

	private void FindStudentAndCoursesById(AppDAO appDAO) {
		int id = 2;
		System.out.println("finding student with id " + id);

		Student student = appDAO.getStudentWithCourseById(id);
		System.out.println("student is " + student);
		System.out.println("associated courses are "+ student.getCourses());
	}

	private void FindCourseAndStudentsById(AppDAO appDAO) {
		int id = 10;
		System.out.println("finding course with students by id " + id);

		Course course = appDAO.getCourseWithStudentsById(id);
		System.out.println("course with given id is " + course);
		System.out.println("associated students are " + course.getStudents());
	}

	private void CreateStudentAndCourse(AppDAO appDAO) {
		Course course = new Course("spring boot");

		course.addStudent(new Student("Ayush", "Gupta", "ayush@gmail.com"));
		course.addStudent(new Student("Jyoti", "Gupta", "jyoti@gmail.com"));

		appDAO.saveCourse(course);

		System.out.println("course is " + course);
		System.out.println("Associated students are " + course.getStudents());
	}

	private void FindCourseAndReviewsById(AppDAO appDAO) {
		int id = 12;
		System.out.println("finding course with id " + id);

		Course course = appDAO.getCourseWithReviewsById(id);
		System.out.println("course is "+ course);
		System.out.println("reviews are " + course.getReviews());
	}

	private void SaveCourse(AppDAO appDAO) {
		Course course = new Course("spring boot");

		course.addReview(new Review("good"));
		course.addReview(new Review("good"));
		course.addReview(new Review("good"));

		System.out.println("Course is " + course);
		System.out.println("reviews are " + course.getReviews());

		appDAO.saveCourse(course);
		System.out.println("saved");
	}

	private void DeleteCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting course with id: " + id);
		appDAO.deleteCourseById(id);
	}

	private void UpdateCourse(AppDAO appDAO) {
		int id = 1;
		System.out.println("updating course");

		Course course = appDAO.findCourseById(id);
		course.setTitle("Pottery");

		course = appDAO.update(course);
		System.out.println("updated course " + course);
	}

	private void UpdateInstructor(AppDAO appDAO) {
		int id = 5;
		System.out.println("updating instructor");

		Instructor instructor = appDAO.findById(id);
		instructor.setLastName("Potter");

		instructor = appDAO.update(instructor);
		System.out.println("updated instructor " + instructor);
	}

	private void FindInstructorWithJoin(AppDAO appDAO) {
		int id = 5;
		System.out.println("find instructor with id: " + id);

		Instructor instructor = appDAO.findInstructorWithJoin(id);
		System.out.println("found instructor "+ instructor);
		System.out.println("associated courses " + instructor.getCourses());
	}

	private void FindCoursesByInstructorId(AppDAO appDAO) {
		int id = 5;
		System.out.println("finding instructor with id: " + id);

		Instructor instructor = appDAO.findById(id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);

		System.out.printf("instructor " + instructor);
		System.out.println("courses for instructor " + instructor.getCourses());
	}

	private void CreateInstructorWithCourses(AppDAO appDAO) {
		Instructor madhur = new Instructor("madhur", "Patel", "chad.derby@love2code.com");

		System.out.println("created instructor madhu " + madhur);

		InstructorDetail madhurDetails = new InstructorDetail("yt.com", "guitar");

		System.out.println("created instructor details" + madhurDetails);

		madhur.setInstructorDetail(madhurDetails);

		Course math = new Course("maths");
		Course science = new Course("science");

		madhur.addCourse(math);
		madhur.addCourse(science);

		System.out.println(madhur);
		appDAO.save(madhur);

		System.out.println("saved madhu " + madhur);
	}

	private void FindAllInstructor(AppDAO appDAO) {
		System.out.println("all the instructors are ");
		List<Instructor> instructors = appDAO.findAll();
		for(Instructor instructor: instructors){
			System.out.println(instructor);
		}
	}

	private void DeleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		System.out.println("Deleting instructor detail with id: " + id);

		appDAO.deleteInstructorDetailById(id);
		System.out.println("deleted");
	}

	private void FindInstructorDetail(AppDAO appDAO) {
		int id = 3;
		System.out.println("Finding instructor detail with id: " + id);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("found instructor detail with id: " + instructorDetail);
		System.out.println("Associated instructor: " + instructorDetail.getInstructor());
	}

	private void DeleteInstructor(AppDAO appDAO) {
		int id = 5;
		System.out.println("Deleting instructor with id " + id);
		appDAO.deleteById(id);
		System.out.println("done");
	}

	private void FindInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("finding instructor with id: " + id);

		Instructor instructor = appDAO.findById(id);
		System.out.println("found instructor with id " + id + " " + instructor);
		System.out.println("details of instructor are " + instructor.getInstructorDetail());
	}

	private void CreateInstructor(AppDAO appDAO) {
		/*Instructor chad = new Instructor("Chad", "Derby", "chad.derby@love2code.com");

		System.out.println("created instructor chad " + chad);

		InstructorDetail chadDetails = new InstructorDetail("yt.com", "code");

		System.out.println("created instructor details" + chadDetails);

		chad.setInstructorDetails(chadDetails);
		*/
		Instructor madhu = new Instructor("madhu", "Patel", "chad.derby@love2code.com");

		System.out.println("created instructor madhu " + madhu);

		InstructorDetail madhuDetails = new InstructorDetail("yt.com", "guitar");

		System.out.println("created instructor details" + madhuDetails);

		madhu.setInstructorDetail(madhuDetails);

		appDAO.save(madhu);

		System.out.println("saved madhu " + madhu);
	}

}
