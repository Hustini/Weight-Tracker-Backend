package org.hustini.weighttracker.authentication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private String message;
    private String token;
    private long expiresIn;

    public LoginDTO(String message, long expiresIn) {
        this.message = message;
        // this.token = token;
        this.expiresIn = expiresIn;
    }
}
