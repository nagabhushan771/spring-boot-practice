package com.spring.data.jpa.SpringDataJPAPractice.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.SpringDataJPAPractice.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

	Page<Course> findByTitleContaining(String title, Pageable pageable);
}
