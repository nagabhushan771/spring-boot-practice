package com.nags.springBoot.practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nags.springBoot.practice.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

	Department findByDepartmentName(String departmentName);
	Department findByDepartmentNameIgnoreCase(String departmentName);
}
