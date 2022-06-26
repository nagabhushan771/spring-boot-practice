package com.nags.springBoot.practice.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.nags.springBoot.practice.entity.Department;
import com.nags.springBoot.practice.errors.DepartmentNotFoundException;
import com.nags.springBoot.practice.repo.DepartmentRepo;
import com.nags.springBoot.practice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepo departmentRepo;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> getDepartments() {
		return departmentRepo.findAll();
	}

	@Override
	public Department getDepartment(Long id) throws DepartmentNotFoundException {
		Optional<Department> department = departmentRepo.findById(id);
		if(!department.isPresent())
			throw new DepartmentNotFoundException("Department Not Available");
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long id) throws DepartmentNotFoundException {
		try {
			departmentRepo.deleteById(id);
		} catch (Exception e) {
			throw new DepartmentNotFoundException("Department Not Available");
		}
		
	}

	@Override
	public Department updateDepartment(Long id, Department department) throws DepartmentNotFoundException {
		Optional<Department> departmentOptional = departmentRepo.findById(id);
		
		if(!departmentOptional.isPresent())
			throw new DepartmentNotFoundException("Department Not Available");
		
		Department dbDepartment = departmentOptional.get();
		if(Objects.nonNull(dbDepartment.getDepartmentName()) && !("".equals(department.getDepartmentName()))) {
			dbDepartment.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(dbDepartment.getDepartmentCode()) && !("".equals(department.getDepartmentCode()))) {
			dbDepartment.setDepartmentCode(department.getDepartmentCode());
		}
		if(Objects.nonNull(dbDepartment.getDepartmentAddress()) && !("".equals(department.getDepartmentCode()))) {
			dbDepartment.setDepartmentCode(department.getDepartmentCode());
		}
		
		return departmentRepo.save(dbDepartment);
	}

	@Override
	public Department getDepartmentByName(String departmentStringName) {
		return departmentRepo.findByDepartmentNameIgnoreCase(departmentStringName);
	}
	
	
	
	

}
