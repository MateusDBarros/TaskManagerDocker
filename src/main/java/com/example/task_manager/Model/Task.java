package com.example.task_manager.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;

    private String name;
    private Priority priority;
    private boolean done;

    public Task() {
    }

    public Task(long taskId, boolean done, Priority priority, String name) {
        this.taskId = taskId;
        this.done = done;
        this.priority = priority;
        this.name = name;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
