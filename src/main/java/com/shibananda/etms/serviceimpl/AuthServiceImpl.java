package com.shibananda.etms.serviceimpl;

import org.springframework.stereotype.Service;

import com.shibananda.etms.dto.EmployeeDTO;
import com.shibananda.etms.entity.Employee;
import com.shibananda.etms.repository.EmployeeRepository;
import com.shibananda.etms.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	private final EmployeeRepository employeeRepository;

	public AuthServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDTO register(EmployeeDTO employeeDTO) {

		Employee employee = new Employee();

		employee.setName(employeeDTO.getName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setDepartment(employeeDTO.getDepartment());
		employee.setPhone(employeeDTO.getPhone());
		employee.setPassword(employeeDTO.getPassword());
		employee.setRole(employeeDTO.getRole());

		Employee savedEmployee = employeeRepository.save(employee);

		EmployeeDTO dto = new EmployeeDTO();

		dto.setId(savedEmployee.getId());
		dto.setName(savedEmployee.getName());
		dto.setEmail(savedEmployee.getEmail());
		dto.setDepartment(savedEmployee.getDepartment());
		dto.setPhone(savedEmployee.getPhone());
		dto.setPassword(savedEmployee.getPassword());
		dto.setRole(savedEmployee.getRole());

		return dto;
	}
}
