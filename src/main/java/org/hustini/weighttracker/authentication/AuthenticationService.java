package org.hustini.weighttracker.authentication;

import org.hustini.weighttracker.user.User;
import org.hustini.weighttracker.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, AuthenticationManager authenticationManager, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(AuthenticationRequestDTO authenticationRequestDTO) {
        System.out.println(authenticationRequestDTO.getUsername() + " " + authenticationRequestDTO.getPassword());
        User user = userRepository.findByUsername(authenticationRequestDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        User u = userRepository.findByUsername(authenticationRequestDTO.getUsername()).orElseThrow();
        System.out.println("Stored pw = " + u.getPassword());
        System.out.println("Matches = " + passwordEncoder.matches(authenticationRequestDTO.getPassword(), u.getPassword()));

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDTO.getUsername(), authenticationRequestDTO.getPassword()));
        return user;
    }
}
