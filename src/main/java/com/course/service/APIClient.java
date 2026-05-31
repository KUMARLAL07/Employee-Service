package com.course.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.course.dto.DepartmentDto;

@FeignClient(url = "localhost:8080",value = "DepartmentService")
public interface APIClient {

	
	@GetMapping("/api/departments/{department-code}")
	public DepartmentDto getDepartment(@PathVariable("department-code")String  departmentCode );
	
}
