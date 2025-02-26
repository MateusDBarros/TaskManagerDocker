package com.example.task_manager.Controller;

import com.example.task_manager.Model.Task;
import com.example.task_manager.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService services;

    public TaskController(TaskService services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        services.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body("Nova Task adicionada");
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        services.
    }
}
