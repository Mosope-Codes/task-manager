package com.task.taskmanager.controller;

import java.util.UUID;
import java.util.List;
import java.util.Map;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import lombok.RequiredArgsConstructor;

import com.task.taskmanager.entity.Task;
import com.task.taskmanager.repository.TaskRepository;
import com.task.taskmanager.exception.EntityNotFoundException;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class TaskController {
    private final TaskRepository taskRepository;

    @GetMapping("/tasks")
    public ResponseEntity<Page<Task>> doGetTasks(Pageable pageable) {
        Page<Task> tasks = taskRepository.findAll(pageable);

        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> doGetSingleTask(@PathVariable("id") UUID id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        return ResponseEntity.ok().body(task);
    }

    @PostMapping("/tasks")
    public ResponseEntity<?> doCreateTask(@RequestBody Task taskRequest) {

        String body = taskRequest.getTaskBody();

        Task task = new Task();

        task.setTaskBody(body);

        taskRepository.save(task);

        return ResponseEntity.ok().body(Map.of("Message", "Task created sucessfully"));

    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<?> doUpdateTask(@PathVariable("id") UUID id, @RequestBody Task taskRequest) {
        
        String taskBody = taskRequest.getTaskBody();

        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        task.setTaskBody(taskBody);

        taskRepository.save(task);

        return ResponseEntity.ok().body(Map.of("Message", "Task updated sucessfully"));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity doDeleteTask(@PathVariable("id") UUID id) {

        taskRepository.deleteById(id);
        
        return ResponseEntity.ok().body(Map.of("Message", "Task deleted sucessfully"));
    }




}
