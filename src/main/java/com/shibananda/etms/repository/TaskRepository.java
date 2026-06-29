package com.shibananda.etms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shibananda.etms.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
