package com.example.desafio.model.project;

import com.example.desafio.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator_project_id")
    private User user;
    private String passwordAccess;
    private String nameProject;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Project(){
        this.startDate=LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Project project)) return false;
        return Objects.equals(getId(), project.getId()) && Objects.equals(getUser(), project.getUser()) && Objects.equals(getPasswordAccess(), project.getPasswordAccess()) && Objects.equals(getNameProject(), project.getNameProject()) && Objects.equals(getDescription(), project.getDescription()) && Objects.equals(getStartDate(), project.getStartDate()) && Objects.equals(getEndDate(), project.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getPasswordAccess(), getNameProject(), getDescription(), getStartDate(), getEndDate());
    }
}
