package com.shibananda.etms.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskDTO {

	private Long id;

	@NotBlank(message = "Title is required")
	private String title;

	@NotBlank(message = "Description is required")
	private String description;

	@NotBlank(message = "Status is required")
	private String status;

	@NotNull(message = "Due date is required")
	@FutureOrPresent(message = "Due date cannot be in the past")
	private LocalDate dueDate;

	@NotNull(message = "Employee Id is required")
	private Long employeeId;

	public TaskDTO() {
		super();
	}

	public TaskDTO(Long id, String title, String description, String status, LocalDate dueDate, Long employeeId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.dueDate = dueDate;
		this.employeeId = employeeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}
