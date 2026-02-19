package org.hustini.weighttracker.authentication;

import org.hustini.weighttracker.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public AuthenticationService() {}

    public void login(AuthentictionRequestDTO authentictionRequestDTO) {
        System.out.println("Service called");
    }
}
