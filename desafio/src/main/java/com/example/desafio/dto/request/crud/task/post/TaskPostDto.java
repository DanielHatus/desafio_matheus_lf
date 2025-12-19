package com.example.desafio.dto.request.crud.task.post;

import com.example.desafio.enums.Priority;
import com.example.desafio.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskPostDto{
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

    @NotNull
    private Long idProject;

    @NotBlank
    @Size(min=4,max=12)
    private String passwordAccessProject;


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

    public String getPasswordAccessProject() {
        return passwordAccessProject;
    }

    public void setPasswordAccessProject(String passwordAccessProject) {
        this.passwordAccessProject = passwordAccessProject;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }
}
