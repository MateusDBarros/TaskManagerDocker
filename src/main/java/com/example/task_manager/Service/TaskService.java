package com.example.task_manager.Service;

import com.example.task_manager.Model.Task;
import com.example.task_manager.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void createTask(Task task) {
        if (task.getName() == null || task.getName().isEmpty())
            throw new IllegalStateException("Insira um nome valido para a task");
        if (task.getPriority() == null)
            throw new IllegalStateException("Defina um nivel de prioridade");
        repository.save(task);
    }

    public Optional<Task> findById(long id) {
        boolean exist = repository.existsById(id);

        if (exist)
            return repository.findById(id);
        else
            throw new IllegalStateException("ID escolhido para busca, não existe");
    }


}
