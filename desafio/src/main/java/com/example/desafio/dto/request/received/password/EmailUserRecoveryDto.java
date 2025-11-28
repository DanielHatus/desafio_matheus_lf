package com.example.desafio.dto.request.received.password;

import jakarta.validation.constraints.Email;

public class EmailUserRecoveryDto {
    @Email(message = "email is invalid. please send one email valid.")
    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
