package com.shibananda.etms.serviceimpl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shibananda.etms.dto.EmployeeDTO;
import com.shibananda.etms.dto.LoginRequest;
import com.shibananda.etms.entity.Employee;
import com.shibananda.etms.jwt.JwtUtil;
import com.shibananda.etms.repository.EmployeeRepository;
import com.shibananda.etms.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	private final EmployeeRepository employeeRepository;

	private final PasswordEncoder passwordEncoder;

	private final JwtUtil jwtUtil;

	public AuthServiceImpl(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		this.employeeRepository = employeeRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public EmployeeDTO register(EmployeeDTO employeeDTO) {

		Optional<Employee> existingEmployee = employeeRepository.findByEmail(employeeDTO.getEmail());

		if (existingEmployee.isPresent()) {
			throw new RuntimeException("Email already exists");
		}

		Employee employee = new Employee();

		employee.setName(employeeDTO.getName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setDepartment(employeeDTO.getDepartment());
		employee.setPhone(employeeDTO.getPhone());
		// employee.setPassword(employeeDTO.getPassword());
		employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
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

	@Override
	public String login(LoginRequest loginRequest) {

		Employee employee = employeeRepository.findByEmail(loginRequest.getEmail())
				.orElseThrow(() -> new RuntimeException("Invalid Email or Password"));

		if (!passwordEncoder.matches(loginRequest.getPassword(), employee.getPassword())) {
			throw new RuntimeException("Invalid Email or Password");
		}

		return jwtUtil.generateToken(employee.getEmail());
	}
}
