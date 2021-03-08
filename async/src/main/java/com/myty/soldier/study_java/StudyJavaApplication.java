package com.myty.soldier.study_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class StudyJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyJavaApplication.class, args);
	}

}
