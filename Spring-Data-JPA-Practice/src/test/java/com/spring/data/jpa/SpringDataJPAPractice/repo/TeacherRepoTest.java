package com.spring.data.jpa.SpringDataJPAPractice.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.SpringDataJPAPractice.entity.Course;
import com.spring.data.jpa.SpringDataJPAPractice.entity.Teacher;

@SpringBootTest
class TeacherRepoTest {

	@Autowired
	private TeacherRepo teacherRepo;
	
	@Test
	public void saveTeacher() {
		Course courseDBA = Course.builder()
				.title("DBA")
				.credit(5)
				.build();
		Course courseJava = Course.builder()
				.title("Java")
				.credit(6)
				.build();
		Teacher teacher = Teacher.builder()
				.firstName("Prasanna")
				.lastName("Kumar")
				.courses(List.of(courseDBA, courseJava))
				.build();
		teacherRepo.save(teacher);

	}

}
