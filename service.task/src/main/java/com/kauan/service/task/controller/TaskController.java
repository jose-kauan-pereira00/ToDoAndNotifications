package com.kauan.service.task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kauan.service.task.dto.request.TaskRequest;
import com.kauan.service.task.model.TasksEntity;
import com.kauan.service.task.repository.TaskRepository;


/**
 * REST controller for managing task operations.
 * Provides endpoints for creating and managing tasks within the task service.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    /**
     * Constructs a TaskController with the specified TaskRepository.
     *
     * @param taskRepository the repository used for task data persistence
     */
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Creates a new task based on the provided task request.
     *
     * @param task the task request containing the task details
     * @return a ResponseEntity containing the created TasksEntity with HTTP status 200
     */
    @PostMapping
    public ResponseEntity<TasksEntity> createTask(@RequestBody TaskRequest task) {
        TasksEntity taskEntity = new TasksEntity(task);
        return ResponseEntity.ok(taskRepository.save(taskEntity));
    }

}
