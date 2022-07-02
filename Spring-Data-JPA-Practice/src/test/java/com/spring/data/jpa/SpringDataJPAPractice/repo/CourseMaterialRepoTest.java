package com.spring.data.jpa.SpringDataJPAPractice.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.SpringDataJPAPractice.entity.Course;
import com.spring.data.jpa.SpringDataJPAPractice.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepoTest {

	@Autowired
	CourseMaterialRepo courseMaterialRepo;

//	@Test
	public void saveCourseMaterial() {
		Course course = Course.builder()
				.title("DSA")
				.credit(5)
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("www.google.com")
				.course(course)
				.build();
		courseMaterialRepo.save(courseMaterial);
	}
	
//	@Test
	public void printAllCourseMaterial() {
		List<CourseMaterial> courseMaterials = courseMaterialRepo.findAll();
		System.out.println(courseMaterials.toString());
	}
}
