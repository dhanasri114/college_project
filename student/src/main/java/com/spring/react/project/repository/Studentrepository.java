package com.spring.react.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.spring.react.project.details.Student;

@Repository
public interface Studentrepository extends JpaRepository<Student, Integer>
{
	
}
