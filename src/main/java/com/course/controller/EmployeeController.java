package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.dto.APIResponseDto;
import com.course.dto.EmployeeDto;
import com.course.entity.Employee;
import com.course.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto dto) {
		
	EmployeeDto savEmployee =	service.saveEmployee(dto);
		
		return new ResponseEntity<>(savEmployee, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long id){
		
	APIResponseDto responseDto =service.getEmployeeById(id);
		
		return new ResponseEntity<>(responseDto , HttpStatus.OK);
	}
	
	@GetMapping
	public List<Employee> getAllEmployee() {
		
		return service.getAllEmployees();
	}
	
}
