package com.nags.springBoot.practice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nags.springBoot.practice.entity.Department;
import com.nags.springBoot.practice.repo.DepartmentRepo;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	DepartmentService departmentService;
	
	@MockBean
	DepartmentRepo departmentRepo;

	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder().departmentName("Computer Science").departmentCode("CS")
				.departmentAddress("4th cross, 2nd block").departmentId(1l).build();
		
		Mockito.when(departmentRepo.findByDepartmentNameIgnoreCase("Computer Science")).thenReturn(department);
	}

	@Test
	@DisplayName("Get data based on valid department name")//to give the meaningful display name for the test case
//	@Disabled//to disable the testcase while testing
	void whenValidName_ShouldGetRightObject() {
		String departmentName = "Computer Science";
		Department department = departmentService.getDepartmentByName(departmentName);
		
		assertEquals(departmentName, department.getDepartmentName());
	}

}
