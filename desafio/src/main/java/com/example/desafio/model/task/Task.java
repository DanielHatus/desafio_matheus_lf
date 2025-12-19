package com.example.desafio.model.task;

import com.example.desafio.enums.Priority;
import com.example.desafio.enums.Status;
import com.example.desafio.model.project.Project;
import com.example.desafio.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titleTask;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDate dueDate;
    @ManyToOne
    @JoinColumn(name = "creator_task_id")
    private User user;
    private LocalDate startDate;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Task(){
        this.startDate=LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Task task)) return false;
        return Objects.equals(getId(), task.getId()) && Objects.equals(getTitleTask(), task.getTitleTask()) && Objects.equals(getDescription(), task.getDescription()) && getStatus() == task.getStatus() && getPriority() == task.getPriority() && Objects.equals(getDueDate(), task.getDueDate()) && Objects.equals(getUser(), task.getUser()) && Objects.equals(getStartDate(), task.getStartDate()) && Objects.equals(getProject(), task.getProject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitleTask(), getDescription(), getStatus(), getPriority(), getDueDate(), getUser(), getStartDate(), getProject());
    }
}
