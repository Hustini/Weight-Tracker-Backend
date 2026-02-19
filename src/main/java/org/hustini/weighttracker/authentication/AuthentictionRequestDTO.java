package org.hustini.weighttracker.authentication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthentictionRequestDTO {

    private String username;
    private String password;

    public AuthentictionRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
