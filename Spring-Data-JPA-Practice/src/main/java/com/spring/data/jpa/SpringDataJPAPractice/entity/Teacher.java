package com.spring.data.jpa.SpringDataJPAPractice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
	
	@Id
	@SequenceGenerator(
			name = "teacher_sequence",
			sequenceName = "teacher_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "teacher_sequence"
	)
	private Long teacherId;
	private String firstName;
	private String lastName;
	
	
	//One to many relationship is not advised we are advised to use Many to one where all we can
//	@OneToMany(
//			cascade = CascadeType.ALL
//	)
//	@JoinColumn(
//			name = "teacher_id",
//			referencedColumnName = "teacherId"
//	)
//	private List<Course> courses;
}
