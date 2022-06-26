package com.nags.springBoot.practice.service;

import java.util.List;

import com.nags.springBoot.practice.entity.Department;
import com.nags.springBoot.practice.errors.DepartmentNotFoundException;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> getDepartments();

	Department getDepartment(Long id) throws DepartmentNotFoundException;

	void deleteDepartmentById(Long id) throws DepartmentNotFoundException;

	Department updateDepartment(Long id, Department department) throws DepartmentNotFoundException;

	Department getDepartmentByName(String departmentStringName);
}
