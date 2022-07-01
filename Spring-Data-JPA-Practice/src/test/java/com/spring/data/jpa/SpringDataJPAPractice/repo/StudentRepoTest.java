package com.spring.data.jpa.SpringDataJPAPractice.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.SpringDataJPAPractice.entity.Gaurdian;
import com.spring.data.jpa.SpringDataJPAPractice.entity.Student;

import lombok.Builder;

@SpringBootTest
class StudentRepoTest {
	
	@Autowired
	StudentRepo studentRepo;

	@BeforeEach
	void setUp() throws Exception {
	}

//	@Test
//	public void saveStudent() {
//		Student student = Student.builder().firstName("Magabhushan").lastName("M").emailId("nags4545@gmail.com")
////				.gaurdianName("Magesh").gaurdianEmailId("magesh5454@gmail.com").gaurdianMobile("8277172234").build();
//		
//		studentRepo.save(student);
//	}
	
//	@Test
	public void saveStudent() {
		//Lets first define the gaurdian
		Gaurdian gaurdian = Gaurdian.builder()
				.emailId("nikhil@gmail.com")
				.name("Nikhil")
				.mobile("9999999999")
				.build();
		
		Student student = Student.builder()
				.emailId("anil3@gmail.com")
				.firstName("Vnil")
				.lastName(null)
				.gaurdian(gaurdian)
				.build();
		studentRepo.save(student);

	}
	
//	@Test
	public void getStudentByFirstName() {
		List<Student> students = studentRepo.findByFirstName("anil");
		System.out.println(students.toString());
	}
	
//	@Test
	public void getStudents() {
		List<Student> studentsList = studentRepo.findAll();
		System.out.println(studentsList.toString());
	}
	
//	@Test
	public void getStudentByFirstNameWhichContains() {
		List<Student> students = studentRepo.findByFirstNameContains("agab");
		System.out.println(students.toString());
	}
	
//	@Test
	public void getStudentByLastNameNotNull() {
		List<Student> students = studentRepo.findByLastNameNotNull();
		System.out.println(students.toString());
	}
	
//	@Test
	public void getStudentByGaurdianName() {
		List<Student> students = studentRepo.findByGaurdianName("Nagesh");
		System.out.println(students.toString());
	}
	
//	@Test
	public void getStudentByEmailId() {
		Student student = studentRepo.getStudentsByEmailId("nags5454@gmail.com");
		System.out.println(student.toString());
	}
	
//	@Test
	public void getStudentByEmailIdByNativeQuery() {
		Student student = studentRepo.getStudentByEmailIdNateive("anil@gmail.com");
		System.out.println(student.toString());
	}
	
	@Test
	public void getStudentByEmailIdByNativeNamedParam() {
		Student student = studentRepo.getStudentByEmailIdNativeNamedParam("anil2@gmail.com");
		System.out.println(student.toString());
	}
}
