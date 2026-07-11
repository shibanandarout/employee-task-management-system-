package com.shibananda.etms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shibananda.etms.dto.EmployeeDTO;
import com.shibananda.etms.dto.LoginRequest;
import com.shibananda.etms.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/register")
	public ResponseEntity<EmployeeDTO> register(@RequestBody @Valid EmployeeDTO employeeDTO) {

		EmployeeDTO savedEmployee = authService.register(employeeDTO);

		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {

		String response = authService.login(loginRequest);

		return ResponseEntity.ok(response);
	}
}
