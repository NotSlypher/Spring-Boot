package com.spring.jpa_advanced;

import com.spring.jpa_advanced.dao.AppDAO;
import com.spring.jpa_advanced.entity.Instructor;
import com.spring.jpa_advanced.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			CreateInstructor(appDAO);
//			FindInstructor(appDAO);
//			DeleteInstructor(appDAO);
//			FindInstructorDetail(appDAO);
//			DeleteInstructorDetail(appDAO);
			FindAllInstructor(appDAO);
		};
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
		int id = 1;
		System.out.println("Finding instructor detail with id: " + id);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("found instructor detail with id: " + instructorDetail);
		System.out.println("Associated instructor: " + instructorDetail.getInstructor());
	}

	private void DeleteInstructor(AppDAO appDAO) {
		int id = 3;
		System.out.println("Deleting instructor with id " + id);
		appDAO.deleteById(id);
		System.out.println("done");
	}

	private void FindInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("finding instructor with id: " + id);

		Instructor instructor = appDAO.findById(id);
		System.out.println("found instructor with id " + id + " " + instructor);
		System.out.println("details of instructor are " + instructor.getInstructorDetails());
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

		madhu.setInstructorDetails(madhuDetails);

		appDAO.save(madhu);

		System.out.println("saved madhu " + madhu);
	}

}
