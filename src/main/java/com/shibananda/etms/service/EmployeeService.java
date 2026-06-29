package com.shibananda.etms.service;

import java.util.List;

import com.shibananda.etms.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO getEmployeeById(Long id);

	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

	void deleteEmployee(Long id);
	
	
}
