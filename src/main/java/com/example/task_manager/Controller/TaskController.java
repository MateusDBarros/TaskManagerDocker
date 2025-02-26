package com.example.task_manager.Controller;

import com.example.task_manager.Model.Task;
import com.example.task_manager.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        List<Task> taskList = services.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(taskList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> findById(@RequestParam long id) {
        Optional<Task> task = services.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@RequestBody Task task, @RequestParam long id) {
        task.setTaskId(id);
        services.updateTask(task);
        return ResponseEntity.status(HttpStatus.OK).body("Task atualizada com sucesso!");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@RequestParam long id) {
        services.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).body("Task com ID: " +id+ " foi apagada com sucesso!");
    }
}
