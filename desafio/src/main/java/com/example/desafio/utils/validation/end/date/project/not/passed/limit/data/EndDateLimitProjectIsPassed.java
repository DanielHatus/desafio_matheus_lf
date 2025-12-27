package com.example.desafio.utils.validation.end.date.project.not.passed.limit.data;

import com.example.desafio.exceptions.typo.runtime.badrequest.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class EndDateLimitProjectIsPassed{

    public void ifPassedThrow(LocalDate endDateProject){
        if (endDateProject.isBefore(LocalDate.now())){
            log.error("❌ The user tried to create a task for a project that had exceeded its deadline.");
            throw new BadRequestException("It was not possible to create the task for this project because the deadline has already passed. Ask the creator to extend the deadline or create a new project.");
        }
    }
}
