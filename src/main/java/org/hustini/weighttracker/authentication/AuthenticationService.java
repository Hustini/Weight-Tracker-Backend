package org.hustini.weighttracker.authentication;

import org.hustini.weighttracker.user.User;
import org.hustini.weighttracker.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    public User login(AuthenticationRequestDTO authenticationRequestDTO) {
        System.out.println(authenticationRequestDTO.getUsername() + " " + authenticationRequestDTO.getPassword());
        User user = userRepository.findByUsername(authenticationRequestDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDTO.getUsername(), authenticationRequestDTO.getPassword()));
        return user;
    }
}
