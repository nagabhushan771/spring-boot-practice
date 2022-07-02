package com.spring.data.jpa.SpringDataJPAPractice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.spring.data.jpa.SpringDataJPAPractice.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	//just by defining the method here we are able to fetch or use this in our application the query will
	//be generated automatically by the JPA 
	//this method fetches the student details whose name exactly matches with the argument passed
	public List<Student> findByFirstName(String firstName);
	//this method will fetch the student details based on the firstname but by ignoring the case
	//i.e. anil is same as Anil
	public List<Student> findByFirstNameIgnoreCase(String firstName);
	//this method will fetch the student details based on the first name of the students but it will fetch
	//all the details where the firstname contains the given input string
	public List<Student> findByFirstNameContains(String firstName);
	//this method will fetch the detail of all students whose lastname is not null
	public List<Student> findByLastNameNotNull();
	//this method will fetch the student details from the db whose gaurdians name is equal to the input string
	public List<Student> findByGaurdianName(String name);
	
	//now lets start to write the jpql query by overselves
	//JPQL qoeries are defined based on the Class names and the attributes of the calsses we should not use the 
	//tabel name and the column names here
	@Query("select s from Student s where s.emailId = ?1")
	public Student getStudentsByEmailId(String emailId);
	
	//now lets write the function which uses the native sql query as the query
	//here we should use the tabel names and the column names
	@Query(
			value = "select * from tbl_student s where s.email_address = ?1",
			nativeQuery = true
	)
	public Student getStudentByEmailIdNateive(String emailId);
	
	//instead of using the ?1, ?2 and all we can use the parameter name in the query by defining them 
	//priorly usinf the @Param anotation in the function declaration before the respective parameter
	@Query(
			value = "select * from tbl_student s where s.email_address = :emailId",
			nativeQuery = true
	)
	public Student getStudentByEmailIdNativeNamedParam(@Param("emailId") String emailId);
	
	//now lets try updating the values in the database
	@Modifying//since we are modifying the data of the database so we need to add the modifying annotation
	@Transactional//since we are taking the data and updating the data and then again saving back it 
	//to the db this can be a transaction
	@Query(
			value = "update tbl_student set first_name = ?1 where email_address = ?2",
			nativeQuery = true
	)
	public int updateFirstNameByEmailId(String firstName, String emailId);
}
