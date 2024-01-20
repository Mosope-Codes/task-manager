package com.task.taskmanager.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.task.taskmanager.entity.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, UUID> {
    
    Optional<Task> findById(UUID id);

    void deleteById(UUID id);

    Task save(Task task);
}
