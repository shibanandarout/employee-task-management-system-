package com.shibananda.etms.serviceimpl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shibananda.etms.entity.Employee;
import com.shibananda.etms.repository.EmployeeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	public final EmployeeRepository employeeRepository;

	public CustomUserDetailsService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Employee employee=employeeRepository.findByEmail(username)
						  .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		
		return User.builder()
				   .username(employee.getEmail())
				   .password(employee.getPassword())
				   .roles(employee.getRole())
				   .build();
	}

}
