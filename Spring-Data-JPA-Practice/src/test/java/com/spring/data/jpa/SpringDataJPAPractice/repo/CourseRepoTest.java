package com.spring.data.jpa.SpringDataJPAPractice.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.SpringDataJPAPractice.entity.Course;

@SpringBootTest
class CourseRepoTest {

	@Autowired
	private CourseRepo courseRepo;
	
//	@Test
	public void printCourses() {
		List<Course> courses = courseRepo.findAll();
		System.out.println(courses.toString());
	}

}
