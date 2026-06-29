package com.shibananda.etms.service;

import java.util.List;

import com.shibananda.etms.dto.TaskDTO;

public interface TaskService {
	TaskDTO addTask(TaskDTO taskDTO);

	TaskDTO getTaskById(Long id);

	List<TaskDTO> getAllTasks();

	TaskDTO updateTask(Long id, TaskDTO taskDTO);

	void deleteTask(Long id);
}
