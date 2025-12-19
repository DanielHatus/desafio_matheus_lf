package com.example.desafio.utils.validation.password.bycrypt.hash.is.equals;

import com.example.desafio.exceptions.typo.runtime.badrequest.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidationIfPasswordHashByCryptIsEquals {

  private final PasswordEncoder passwordEncoder;

    public ValidationIfPasswordHashByCryptIsEquals(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void validationIfHashIsEqualsAndThrowIfNotEquals(String passwordRequest, String hashPasswordEntityProject){
      if (!passwordIsEquals(passwordRequest,hashPasswordEntityProject)){

          log.error("❌ After comparing the hashes, the return was false. Therefore, the password passed in the request is not the same" +
                  " as the one created by the project creator.");
          throw new BadRequestException("The password to access the project provided in the ID is incorrect. " +
                  "Please provide a valid password or reset the password if you are the project creator.");
      }
    }

    private boolean passwordIsEquals(String passwordRequest,String hashPasswordEntityProject){

        log.debug("✅ The comparison of the project password passed in the request with the project password hash was successful." +
                "The result is now being returned.");
       return passwordEncoder.matches(passwordRequest,hashPasswordEntityProject);
    }
}
