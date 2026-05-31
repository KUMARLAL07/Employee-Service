package com.course.service;

import java.util.List;

import com.course.dto.APIResponseDto;
import com.course.dto.EmployeeDto;
import com.course.entity.Employee;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto dto);
	
	APIResponseDto getEmployeeById(Long id) ;
	
	List<Employee> getAllEmployees();
}
