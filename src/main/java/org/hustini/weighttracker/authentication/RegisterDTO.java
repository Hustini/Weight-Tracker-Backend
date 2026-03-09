package org.hustini.weighttracker.authentication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    private String username;
    private String email;
    private String phoneNumber;

    public RegisterDTO(String username, String email, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}