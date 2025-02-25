package com.example.task_manager.Model;

public enum Priority {

    ALTA ("Alta"),
    MEDIA ("Média"),
    BAIXA ("Baixa");

    private final String description;

    Priority(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }
}
