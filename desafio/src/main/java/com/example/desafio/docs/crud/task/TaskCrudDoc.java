package com.example.desafio.docs.crud.task;

import com.example.desafio.dto.request.crud.task.post.TaskPostDto;
import com.example.desafio.dto.request.crud.task.put.TaskPutDto;
import com.example.desafio.dto.response.crud.task.ResponseTaskDataDto;
import com.example.desafio.enums.Priority;
import com.example.desafio.enums.Status;
import com.example.desafio.model.task.Task;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Crud Task Controller",
        description = "This controller is responsible for performing all CRUD operations related to task management.")
public interface TaskCrudDoc {

    @Operation(
            summary = "It is responsible for retrieving tasks according to filters passed by the client.",
            description = "The client can filter tasks by status, priority, and project ID. " +
                    "If the filters are valid, a list of tasks matching the criteria will be returned.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of tasks according to the applied filters."),
                    @ApiResponse(responseCode = "404", description = "Project not found or no tasks registered.")
            }
    )
    ResponseEntity<List<ResponseTaskDataDto>> getTasksByOrder(Status status, Priority priority, Long idProject);


    @Operation(
            summary = "The client passes the task ID and receives the corresponding task data.",
            description = "The client passes the task ID as a path variable. " +
                    "If the task exists, a DTO containing the task data will be returned.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task data successfully returned."),
                    @ApiResponse(responseCode = "404", description = "Task ID not found in database.")
            }
    )
    ResponseEntity<ResponseTaskDataDto> getTaskById(Long id);


    @Operation(
            summary = "Creates a new task and returns the created task data.",
            description = "This method saves the data and creates the entity after all processing and entity assembly are performed in the facade layer. " +
                    "Finally, it returns a DTO containing the data of the newly created entity.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Task successfully created and returned."),
                    @ApiResponse(responseCode = "400", description = "Bad request. Invalid data was provided."),
                    @ApiResponse(responseCode = "404", description = "Related project or user not found.")
            }
    )
    ResponseEntity<ResponseTaskDataDto> createNewTask(TaskPostDto taskPostDto);


    @Operation(
            summary = "Updates the data of an existing task.",
            description = "The client passes the task ID and the new task data. " +
                    "If the user is the creator of the task or has admin privileges, " +
                    "the task data will be updated successfully.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task data successfully updated."),
                    @ApiResponse(responseCode = "403", description = "User does not have permission to update this task."),
                    @ApiResponse(responseCode = "404", description = "Task ID not found in database.")
            }
    )
    ResponseEntity<ResponseTaskDataDto> updateTask(Long id, TaskPutDto taskPutDto);


    @Operation(
            summary = "Deletes a task based on the ID passed by the client.",
            description = "The client passes the task ID. " +
                    "If the task exists, it will be deleted from the database.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Task successfully deleted. No content returned."),
                    @ApiResponse(responseCode = "404", description = "Task ID not found in database.")
            }
    )
    ResponseEntity<Void> deleteTask(Long id);
}

