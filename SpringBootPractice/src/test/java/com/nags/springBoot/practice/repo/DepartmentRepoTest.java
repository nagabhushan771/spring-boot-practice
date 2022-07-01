package com.nags.springBoot.practice.repo;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.nags.springBoot.practice.entity.Department;

@DataJpaTest
class DepartmentRepoTest {
	
	@Autowired
	DepartmentRepo departmentRepo;
	
	@Autowired
	EntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder().departmentName("Mechanical Engineering").departmentCode("ME").departmentAddress("4th Block, Bangalore").build();
		
		entityManager.persist(department);
	}

	@Test
	@DisplayName("Get the department when the Id is present in Database")
	void whenfindDepartmentById_thenReturnDepartment() {
		Department department = departmentRepo.findById(1l).get();
		
		assertEquals(department.getDepartmentName(), "Mechanical Engineering");
	}
	

}
