package com.shibananda.etms.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shibananda.etms.dto.TaskDTO;
import com.shibananda.etms.entity.Employee;
import com.shibananda.etms.entity.Task;
import com.shibananda.etms.exception.ResourceNotFoundException;
import com.shibananda.etms.repository.EmployeeRepository;
import com.shibananda.etms.repository.TaskRepository;
import com.shibananda.etms.service.TaskService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository;
	private final EmployeeRepository employeeRepository;

	public TaskServiceImpl(TaskRepository taskRepository, EmployeeRepository employeeRepository) {

		this.taskRepository = taskRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public TaskDTO addTask(TaskDTO taskDTO) {

		Employee employee = employeeRepository.findById(taskDTO.getEmployeeId()).orElseThrow(
				() -> new ResourceNotFoundException("Employee not found with id : " + taskDTO.getEmployeeId()));

		Task task = mapToEntity(taskDTO);

		task.setEmployee(employee);

		Task savedTask = taskRepository.save(task);

		return mapToDTO(savedTask);
	}

	@Override
	public TaskDTO getTaskById(Long id) {

		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found with id : " + id));

		return mapToDTO(task);
	}

	@Override
	public List<TaskDTO> getAllTasks() {

		return taskRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found with id : " + id));

		Employee employee = employeeRepository.findById(taskDTO.getEmployeeId()).orElseThrow(
				() -> new ResourceNotFoundException("Employee not found with id : " + taskDTO.getEmployeeId()));

		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		task.setStatus(taskDTO.getStatus());
		task.setDueDate(taskDTO.getDueDate());
		task.setEmployee(employee);

		Task updatedTask = taskRepository.save(task);

		return mapToDTO(updatedTask);
	}

	@Override
	public void deleteTask(Long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found with id : " + id));

		taskRepository.delete(task);
	}

	private Task mapToEntity(TaskDTO dto) {

		Task task = new Task();

		task.setId(dto.getId());
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setStatus(dto.getStatus());
		task.setDueDate(dto.getDueDate());

		return task;
	}

	private TaskDTO mapToDTO(Task task) {

		TaskDTO dto = new TaskDTO();

		dto.setId(task.getId());
		dto.setTitle(task.getTitle());
		dto.setDescription(task.getDescription());
		dto.setStatus(task.getStatus());
		dto.setDueDate(task.getDueDate());

		if (task.getEmployee() != null) {
			dto.setEmployeeId(task.getEmployee().getId());
		}

		return dto;

	}

}
