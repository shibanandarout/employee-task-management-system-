package com.shibananda.etms.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shibananda.etms.dto.EmployeeDTO;
import com.shibananda.etms.entity.Employee;
import com.shibananda.etms.exception.ResourceNotFoundException;
import com.shibananda.etms.repository.EmployeeRepository;
import com.shibananda.etms.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = mapToEntity(employeeDTO);

		Employee savedEmployee = employeeRepository.save(employee);

		return mapToDTO(savedEmployee);
	}

	@Override
	public EmployeeDTO getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : " + id));

		return mapToDTO(employee);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		return employeeRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : " + id));

		employee.setName(employeeDTO.getName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setDepartment(employeeDTO.getDepartment());
		employee.setPhone(employeeDTO.getPhone());

		Employee updatedEmployee = employeeRepository.save(employee);

		return mapToDTO(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : " + id));

		employeeRepository.delete(employee);

	}

	private Employee mapToEntity(EmployeeDTO employeeDTO) {

		Employee employee = new Employee();

		employee.setId(employeeDTO.getId());
		employee.setName(employeeDTO.getName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setDepartment(employeeDTO.getDepartment());
		employee.setPhone(employeeDTO.getPhone());

		return employee;
	}

	private EmployeeDTO mapToDTO(Employee employee) {

		EmployeeDTO dto = new EmployeeDTO();

		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setEmail(employee.getEmail());
		dto.setDepartment(employee.getDepartment());
		dto.setPhone(employee.getPhone());

		return dto;
	}
}
