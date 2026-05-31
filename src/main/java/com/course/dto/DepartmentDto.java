package com.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
	
	 private Long id;
	 private String departmentName;
	 private String departmentDescription;
	 private String departmentCode;

}
