package com.spring.data.jpa.SpringDataJPAPractice.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.spring.data.jpa.SpringDataJPAPractice.entity.Course;
import com.spring.data.jpa.SpringDataJPAPractice.entity.Student;
import com.spring.data.jpa.SpringDataJPAPractice.entity.Teacher;

@SpringBootTest
class CourseRepoTest {

	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private TeacherRepo teacherRepo;
	
//	@Test
	public void printCourses() {
		List<Course> courses = courseRepo.findAll();
		System.out.println(courses.toString());
	}
	
//	@Test
	public void saveCourseWithTeacher() {
//		Teacher teacher = Teacher.builder()
//				.firstName("Prabodh")
//				.lastName("C P")
//				.build();
		Teacher teacher = teacherRepo.findById((long)2).get();
		
		Course course = Course.builder()
				.title("FAFL")
				.credit(4)
				.teacher(teacher)
				.build();
		
		courseRepo.save(course);
	}
	
//	@Test
	public void getCourseWithPagable() {
		Pageable pageWithThreeElements =  PageRequest.of(0, 3);
		
		Pageable pageWithTwoElements = PageRequest.of(1, 2);
		
		List<Course> courses = courseRepo.findAll(pageWithTwoElements).getContent();
		
		System.out.println("Numner of Pages : " + courseRepo.findAll(pageWithTwoElements).getTotalPages());
		
		System.out.println(courses.toString());
	}
	
//	@Test
	public void getCoursesWithSorting() {
		Pageable pageWithSotingByTitle = PageRequest.of(0, 3, Sort.by("title"));

		Pageable pageWithSortingByCreditsDescending = PageRequest.of(0, 3, Sort.by("credit").descending());

		Pageable pageWithSortByTitleDescendingAndCredit = PageRequest.of(0, 3,
				Sort.by("title").descending().and(Sort.by("credit")));

		List<Course> courses = courseRepo.findAll(pageWithSortByTitleDescendingAndCredit).getContent();

		System.out.println(courses.toString());
	}
	
//	@Test
	public void prinfFindByTitleContaining() {
		Pageable pageable = PageRequest.of(0, 2);
		
		List<Course> courses =  courseRepo.findByTitleContaining("D", pageable).getContent();
		System.out.println(courses.toString());
	}
	
	@Test
	public void addCourseWithStudentAndTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("Sunitha")
				.lastName("M")
				.build();
		
		Student student = Student.builder()
				.firstName("Manoj")
				.lastName("T S")
				.emailId("manoj@gmail.com")
				.build();
		
		Course course = Course.builder()
				.title("Graph Theory")
				.credit(6)
				.teacher(teacher)
				.build();
		
		course.addStudent(student);
		
		courseRepo.save(course);
	}

}
