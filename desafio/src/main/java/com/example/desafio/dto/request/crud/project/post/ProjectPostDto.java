package com.example.desafio.dto.request.crud.project.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ProjectPostDto{
    @NotBlank
    private String passwordAccess;

    @NotBlank
    private String nameProject;

    @NotBlank
    private String description;

    @NotNull
    private LocalDate endDate;

    public String getPasswordAccess() {
        return passwordAccess;
    }

    public void setPasswordAccess(String passwordAccess) {
        this.passwordAccess = passwordAccess;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
