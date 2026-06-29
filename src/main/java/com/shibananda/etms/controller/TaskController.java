package com.shibananda.etms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shibananda.etms.dto.TaskDTO;
import com.shibananda.etms.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping
	public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO) {

		TaskDTO savedTask = taskService.addTask(taskDTO);

		return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {

		return ResponseEntity.ok(taskService.getTaskById(id));
	}

	@GetMapping
	public ResponseEntity<List<TaskDTO>> getAllTasks() {

		return ResponseEntity.ok(taskService.getAllTasks());
	}

	@PutMapping("/{id}")
	public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {

		return ResponseEntity.ok(taskService.updateTask(id, taskDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Long id) {

		taskService.deleteTask(id);

		return ResponseEntity.ok("Task deleted successfully");
	}
}
