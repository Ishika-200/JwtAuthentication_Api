package com.jobPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobPortal.entity.Student;

public interface StudentRepo extends JpaRepository<Student, String> {

}
