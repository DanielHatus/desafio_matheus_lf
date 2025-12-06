package com.example.desafio.docs.crud.project;

import com.example.desafio.dto.request.crud.project.post.ProjectPostDto;
import com.example.desafio.dto.request.crud.project.put.ProjectPutDto;
import com.example.desafio.dto.response.crud.project.ResponseProjectDataDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@Tag(name="Crud Project Controller"
,description = "This controller is responsible for performing all CRUD operations related to project creation.")
public interface ProjectCrudDoc{

    @Operation(summary = "It is responsible for retrieving projects through pagination based on the client's specific needs.",
            description = "The client will pass the size, page, order, and et as request parameters, " +
                    "and when the response DTO is returned, the paginated list will be in accordance with this " +
                    "specification passed by the client in the request parameters.",
            responses = {
                    @ApiResponse(responseCode = "200")
            })
    public ResponseEntity<Page<ResponseProjectDataDto>> getProjectByOrder(Integer page, Integer size, String order, String direction);


    @Operation(summary = "The client passes the ID as a parameter and receives the project corresponding to that ID, if it exists.",

            description = "The client will pass the user ID in the request body. If an ID exists in the database, " +
                    "a DTO in the response body will return the user's project data, except for the access password," +

                    "which is extremely sensitive data and should not be exposed.",
           responses = {
                   @ApiResponse(responseCode = "200",description = "User project data except for the access password."),
                   @ApiResponse(responseCode = "404",description = "An exception occurred because the ID not passed in the request was not found in the database.")
           })
    public ResponseEntity<ResponseProjectDataDto> getProjectById(Long id);


    @Operation(summary = "The data will be passed to create the project, and if all the data is successfully validated, " +
            "the project will be created and stored in the database.",
    description = "The data for creating the project will be passed, and if all the data is successfully validated, " +
            "the project will be created and stored in the database using the data provided by the user.",
    responses = {
            @ApiResponse(responseCode = "201",description = "user project data"),
            @ApiResponse(responseCode = "404",description = "A bad request occurs if any incorrect data was passed in the request.")
    })
    public ResponseEntity<ResponseProjectDataDto> createNewProject(ProjectPostDto projectPostDto);

    @Operation(summary = "The data for the user-created project will be updated here.",
    description = "The data for the user-created project will be updated here if the data passed in the request is indeed correct.",
    responses = {
            @ApiResponse(responseCode = "200",description = "user project  data"),
            @ApiResponse(responseCode = "404",description = "A bad request occurs if any incorrect data was passed in the request.")
    })
    public ResponseEntity<ResponseProjectDataDto> updateProject(Long id, ProjectPutDto projectPutDto);

    @Operation(summary = "The ID will be passed, and the project associated with that ID in the request will be deleted from the database.",
    description = "The ID will be passed, and the project associated with that ID in the request will be deleted from the database " +
            "if the ID is indeed real and exists in the database.",
    responses = {
            @ApiResponse(responseCode = "204",description = "no content"),
            @ApiResponse(responseCode = "404",description = "id not found in database")
    })
    public ResponseEntity<Void> deleteProjectById(Long id);
}
