package com.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.course.dto.APIResponseDto;
import com.course.dto.DepartmentDto;
import com.course.dto.EmployeeDto;
import com.course.entity.Employee;
import com.course.repository.EmployeeRepository;
import com.course.service.APIClient;
import com.course.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	//@Autowired
	//private WebClient webClient;
	@Autowired
	private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) {

		Employee employee = new Employee(dto.getId(), dto.getFirstName(), dto.getFirstName(), dto.getLastName(),
				dto.getDepartmentCode());

		EmployeeDto saveEmployee = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getEmail(), employee.getDepartmentCode());

		return saveEmployee;
	}

	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {

		Employee employee = repository.findById(employeeId).get();

		/*DepartmentDto departmentDto = webClient.get()
				.uri("http:localhost:8080/api/departments/" + employee.getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDto.class).block();*/
		
DepartmentDto departmentDto =  apiClient.getDepartment(employee.getDepartmentCode());
		

		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getFirstName(),
				employee.getEmail(), employee.getDepartmentCode());

		APIResponseDto apiResponseDto = new APIResponseDto();

		apiResponseDto.setDepartmentDto(departmentDto);
		apiResponseDto.setEmployeeDto(employeeDto);

		return apiResponseDto;
	}

	@Override
	public List<Employee> getAllEmployees() {

		return repository.findAll();
	}

}
