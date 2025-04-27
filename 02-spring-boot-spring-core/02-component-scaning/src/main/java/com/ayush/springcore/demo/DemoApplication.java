package com.ayush.springcore.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication(
		scanBasePackages = {
				"com.ayush.springcore.demo",
				"com.ayush.springcore.utils"
		}
)*/

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
