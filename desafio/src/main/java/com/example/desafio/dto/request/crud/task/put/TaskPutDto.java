package com.example.desafio.dto.request.crud.task.put;

import com.example.desafio.enums.Priority;
import com.example.desafio.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public class TaskPutDto{
    @NotBlank
    private String titleTask;

    @NotBlank
    private String description;

    @NotNull
    private Status status;

    @NotNull
    private Priority priority;

    @NotBlank
    private String dueDate;

    public String getTitleTask() {
        return titleTask;
    }

    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
