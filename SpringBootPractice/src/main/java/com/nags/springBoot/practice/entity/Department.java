package com.nags.springBoot.practice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	
	@Id //to make departmentId as the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)//to auto generate the primary key
	private Long departmentId;
	
	@NotBlank(message = "Please add Department Name")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
}
