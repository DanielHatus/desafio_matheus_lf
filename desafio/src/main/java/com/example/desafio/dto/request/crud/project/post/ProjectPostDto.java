package com.example.desafio.dto.request.crud.project.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ProjectPostDto{
    @NotBlank
    @Size(min=4,max=12)
    private String passwordAccess;

    @NotBlank
    @Size(min=3,max=35)
    private String nameProject;

    @NotBlank
    private String description;

    @NotNull
    private String endDate;

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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
