package com.example.desafio.facade.register.project;

import com.example.desafio.dto.request.crud.project.post.ProjectPostDto;
import com.example.desafio.dto.response.crud.project.ResponseProjectDataDto;
import com.example.desafio.mapper.project.ProjectMapperCore;
import com.example.desafio.model.project.Project;
import com.example.desafio.repository.user.UserRepository;
import com.example.desafio.service.crud.project.ProjectCrudService;
import com.example.desafio.utils.encryptedpassword.EncryptedPassword;
import com.example.desafio.utils.get.username.by.context.security.GetUsernameByContextHolder;
import com.example.desafio.utils.parse.data.from.iso.american.ParseDataFromIsoAmerican;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewProjectFacade{
    private final GetUsernameByContextHolder usernameByContextHolder;
    private final ProjectMapperCore mapperCore;
    private final ParseDataFromIsoAmerican fromIsoAmerican;
    private final ProjectCrudService projectCrudService;
    private final EncryptedPassword encryptedPassword;
    private final UserRepository userRepository;

    public RegisterNewProjectFacade(
            GetUsernameByContextHolder usernameByContextHolder,
            ProjectMapperCore mapperCore,
            ParseDataFromIsoAmerican fromIsoAmerican,
            ProjectCrudService projectCrudService,
            EncryptedPassword encryptedPassword,
            UserRepository userRepository) {

        this.usernameByContextHolder = usernameByContextHolder;
        this.mapperCore = mapperCore;
        this.fromIsoAmerican = fromIsoAmerican;
        this.projectCrudService=projectCrudService;
        this.encryptedPassword=encryptedPassword;
        this.userRepository=userRepository;
    }

    public ResponseProjectDataDto execute(ProjectPostDto projectPostDto){
        Project entityProject=mapperCore.toEntity(projectPostDto);

        entityProject.setUser(userRepository.findByUsername(usernameByContextHolder.execute()).get());

        entityProject.setPasswordAccess(encryptedPassword.encrypted(projectPostDto.getPasswordAccess()));

        entityProject.setEndDate(fromIsoAmerican.parseDataFormatBrazilianImAmerican(projectPostDto.getEndDate()));

        return projectCrudService.saveProjectInDbAndReturnEntityDtoMapped(entityProject);
    }
}
