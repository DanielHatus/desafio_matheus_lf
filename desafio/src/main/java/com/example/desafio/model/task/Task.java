package com.example.desafio.model.task;

import com.example.desafio.enums.Priority;
import com.example.desafio.enums.Status;
import com.example.desafio.model.project.Project;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    private Long id;
    private String titleTask;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDate dueDate;
    private LocalDate startDate;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;



}
