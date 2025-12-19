package com.example.desafio.facade.register.task;

import com.example.desafio.dto.request.crud.task.post.TaskPostDto;
import com.example.desafio.dto.response.crud.task.ResponseTaskDataDto;
import com.example.desafio.exceptions.typo.runtime.notfound.NotFoundException;
import com.example.desafio.mapper.task.TaskMapperCore;
import com.example.desafio.model.project.Project;
import com.example.desafio.model.task.Task;
import com.example.desafio.repository.project.ProjectRepository;
import com.example.desafio.service.crud.task.TaskCrudService;
import com.example.desafio.utils.parse.data.from.iso.american.ParseDataFromIsoAmerican;
import com.example.desafio.utils.validation.password.bycrypt.hash.is.equals.ValidationIfPasswordHashByCryptIsEquals;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegisterNewTaskFacade{

    private final ProjectRepository projectRepository;
    private final ValidationIfPasswordHashByCryptIsEquals validationIfPasswordHashByCryptIsEquals;
    private final TaskMapperCore taskMapperCore;
    private final ParseDataFromIsoAmerican parseDataFromIsoAmerican;
    private final TaskCrudService taskCrudService;


    public RegisterNewTaskFacade(ProjectRepository projectRepository, ValidationIfPasswordHashByCryptIsEquals validationIfPasswordHashByCryptIsEquals, TaskMapperCore taskMapperCore, ParseDataFromIsoAmerican parseDataFromIsoAmerican, TaskCrudService taskCrudService) {
        this.projectRepository = projectRepository;
        this.validationIfPasswordHashByCryptIsEquals = validationIfPasswordHashByCryptIsEquals;
        this.taskMapperCore = taskMapperCore;
        this.parseDataFromIsoAmerican = parseDataFromIsoAmerican;
        this.taskCrudService = taskCrudService;
    }

    public ResponseTaskDataDto execute(TaskPostDto taskPostDto){
        Project entityProject=projectRepository.findById(taskPostDto.getIdProject())
                .orElseThrow(()-> new NotFoundException("id project not found in database"));
        log.debug("✅ A task with the ID {} passed in the request was found.",taskPostDto.getIdProject());

        validationIfPasswordHashByCryptIsEquals.validationIfHashIsEqualsAndThrowIfNotEquals
                (taskPostDto.getPasswordAccessProject(), entityProject.getPasswordAccess());
        log.debug("✅ The password passed in the request was successfully validated. The password is indeed correct and is indeed the" +
                " password for this project.");

        Task taskEntity=taskMapperCore.toEntity(taskPostDto);
        log.debug("✅ The data passed in the request was successfully mapped.");

        taskEntity.setDueDate(parseDataFromIsoAmerican.parseDataFormatBrazilianImAmerican(taskPostDto.getDueDate()));

        return taskCrudService.createTaskAndReturnTaskInDto(taskEntity);
    }
}
