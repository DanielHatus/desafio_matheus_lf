package com.example.desafio.controller.crud.task;

import com.example.desafio.docs.crud.task.TaskCrudDoc;
import com.example.desafio.dto.request.crud.task.post.TaskPostDto;
import com.example.desafio.dto.request.crud.task.put.TaskPutDto;
import com.example.desafio.dto.response.crud.task.ResponseTaskDataDto;
import com.example.desafio.enums.Priority;
import com.example.desafio.enums.Status;
import com.example.desafio.facade.register.task.RegisterNewTaskFacade;
import com.example.desafio.service.crud.task.TaskCrudService;
import com.example.desafio.utils.generate.uri.GenerateUri;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud/task")
public class TaskCrudController implements TaskCrudDoc{

    private final TaskCrudService service;
    private final RegisterNewTaskFacade registerNewTaskFacade;
    private final GenerateUri generateUri;


    public TaskCrudController(TaskCrudService service, RegisterNewTaskFacade registerNewTaskFacade, GenerateUri generateUri) {
        this.service = service;
        this.registerNewTaskFacade = registerNewTaskFacade;
        this.generateUri = generateUri;
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<ResponseTaskDataDto>> getTasksByOrder(
        @RequestParam(required = true) Status status,
        @RequestParam(required = true) Priority priority,
        @RequestParam(required = true) Long idProject){
        return ResponseEntity.ok(service.getTasksByOrder(status, priority, idProject));
     }

    @Override
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ResponseTaskDataDto> getTaskById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getTaskById(id));
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<ResponseTaskDataDto> createNewTask(@RequestBody @Valid TaskPostDto taskPostDto) {
       ResponseTaskDataDto responseTaskDataDto=registerNewTaskFacade.execute(taskPostDto);
       return ResponseEntity.created(generateUri.build(responseTaskDataDto.getId())).body(responseTaskDataDto);
    }

    @Override
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<ResponseTaskDataDto> updateTask(@PathVariable Long id, @RequestBody @Valid TaskPutDto taskPutDto) {
        return ResponseEntity.ok(service.updateTask(id,taskPutDto));
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
