package com.shibananda.etms.controller;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shibananda.etms.dto.EmployeeDTO;
import com.shibananda.etms.dto.LoginRequest;
import com.shibananda.etms.service.AuthService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
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
	
	@GetMapping("/me")
	public ResponseEntity<EmployeeDTO> getCurrentUser(Authentication authentication) {
	    if (authentication == null || !authentication.isAuthenticated()) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }
	    String email = authentication.getName();
	    EmployeeDTO employee = authService.getEmployeeByEmail(email);
	    return ResponseEntity.ok(employee);
	}
}
