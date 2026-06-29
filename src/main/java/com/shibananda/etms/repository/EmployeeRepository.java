package com.shibananda.etms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shibananda.etms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
		
}
