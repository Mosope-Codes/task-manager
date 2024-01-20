package com.task.taskmanager.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.task.taskmanager.exception.EntityNotFoundException;

@ControllerAdvice
public class EntityNotFoundAdvice {
    
    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<Object> entityNotFoundHandler(EntityNotFoundException ex) {
        Map<String, String> body = Map.of("Message", "Task not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
