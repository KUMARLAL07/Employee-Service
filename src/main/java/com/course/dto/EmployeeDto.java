package com.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDto {
	
   private long id;
   
   private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String departmentCode;
}
