package com.spring.data.jpa.SpringDataJPAPractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.SpringDataJPAPractice.entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

}
