package com.example.desafio.utils.validation.user.is.creator.task;

import com.example.desafio.exceptions.typo.runtime.forbidden.ForbiddenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRequestIsCreatorTask{

    public void  throwIfUserRequestNotCreatorTask(String userUsernameRequest,String usernameCreatorTask){
        if (!usernameCreatorTask.equalsIgnoreCase(userUsernameRequest)){
            log.error("❌ The user cannot update the task because they did not create it. A forbiddenException is returned.");
            throw new ForbiddenException("You cannot update this task because you are not its creator.");
        }
    }
}
