package org.hustini.weighttracker.authentication;

import org.hustini.weighttracker.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    public AuthenticationController(AuthenticationService authenticationService,  JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDTO authenticationRequestDTO) {
        User user = authenticationService.login(authenticationRequestDTO);
        String jwtToken = jwtService.generateToken(user);
        LoginDTO loginMessage = new LoginDTO("Login Successful", jwtToken, jwtService.getExpirationTime());
        return ResponseEntity.ok().body(loginMessage);
    }
}
