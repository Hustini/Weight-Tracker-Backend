package org.hustini.weighttracker.authentication;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public AuthenticationService() {}

    public String login(AuthenticationRequestDTO authenticationRequestDTO) {
        System.out.println("First: " + authenticationRequestDTO.getUsername());
        return authenticationRequestDTO.getUsername();
    }
}
