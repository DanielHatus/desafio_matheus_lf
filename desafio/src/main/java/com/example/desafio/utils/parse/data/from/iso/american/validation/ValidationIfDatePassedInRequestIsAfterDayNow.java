package com.example.desafio.utils.parse.data.from.iso.american.validation;

import com.example.desafio.exceptions.typo.runtime.badrequest.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class ValidationIfDatePassedInRequestIsAfterDayNow {

    public void executeAndThrowIfDataRequestIsBefore(LocalDate localDate){
        if (localDate.isBefore(LocalDate.now())){
            log.error("❌ The previous date is incorrect because it precedes the current date.");
            throw new BadRequestException("Use a valid date to set as the deadline. The date must not be earlier than the current day.");
        }
    }
}
