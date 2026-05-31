package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	
	
}
