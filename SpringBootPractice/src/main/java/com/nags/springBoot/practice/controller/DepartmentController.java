package com.nags.springBoot.practice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nags.springBoot.practice.entity.Department;
import com.nags.springBoot.practice.errors.DepartmentNotFoundException;
import com.nags.springBoot.practice.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside the save department");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartments(){
		LOGGER.info("Inside the get departments");
		return departmentService.getDepartments();
	}
	 
	@GetMapping("/departments/{id}")
	public Department getDepartment(@PathVariable("id") Long id) throws DepartmentNotFoundException {
		return departmentService.getDepartment(id);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
		departmentService.deleteDepartmentById(id);
		return "Department deleted Successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) throws DepartmentNotFoundException {
		return departmentService.updateDepartment(id, department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.getDepartmentByName(departmentName);
	}
}
