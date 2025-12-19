package com.example.desafio.mapper.task;

import com.example.desafio.dto.request.crud.task.post.TaskPostDto;
import com.example.desafio.dto.request.crud.task.put.TaskPutDto;
import com.example.desafio.dto.response.crud.task.ResponseTaskDataDto;
import com.example.desafio.enums.Priority;
import com.example.desafio.enums.Status;
import com.example.desafio.model.task.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskMapperCore{

    @Mapping(target = "dueDate",ignore = true)
    Task toEntity(TaskPostDto taskPostDto);

    @Mapping(target = "dueDate",ignore = true)
    void updatePutTaskData(@MappingTarget Task taskEntity, TaskPutDto taskPutDto);

    List<ResponseTaskDataDto> listEntityTasksInResponseTaskDataDto(List<Task> listTasks);
    ResponseTaskDataDto entityTaskInResponseTaskDataDto(Task entityTask);
}
