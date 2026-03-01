package org.hustini.weighttracker;

import org.hustini.weighttracker.user.User;
import org.hustini.weighttracker.user.UserDTO;
import org.hustini.weighttracker.weight.Weight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartupRunner implements CommandLineRunner {
    @Value("${app.username}")
    private String username;

    @Value("${app.password}")
    private String password;

    @Override
    public void run(String... args) {
        User testUser = new User(username, password);
        Weight weight1 = new Weight(testUser, 50.0);
        Weight weight2 = new Weight(testUser, 60.0);
        List<Weight> weights = new ArrayList<>();
        weights.add(weight1);
        weights.add(weight2);
        UserDTO testUserDTO = new UserDTO(testUser, weights);
        System.out.println("User: " + testUser.getUsername() + " " + testUser.getPassword());
    }
}
