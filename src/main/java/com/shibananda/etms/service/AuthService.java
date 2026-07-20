package com.shibananda.etms.service;

import com.shibananda.etms.dto.EmployeeDTO;
import com.shibananda.etms.dto.LoginRequest;

public interface AuthService {

	EmployeeDTO register(EmployeeDTO employeeDTO);

	String login(LoginRequest loginRequest);
	
	EmployeeDTO getEmployeeByEmail(String email);
}
