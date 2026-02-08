package org.hustini.weighttracker;

import org.hustini.weighttracker.user.User;
import org.hustini.weighttracker.user.UserDTO;
import org.hustini.weighttracker.weight.Weight;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        User user = new User("jeff");
        Weight weight1 = new Weight(user, 50.0);
        Weight weight2 = new Weight(user, 60.0);
        List<Weight> weights = new ArrayList<>();
        weights.add(weight1);
        weights.add(weight2);
        UserDTO test = new UserDTO(user, weights);
        System.out.println("User: " + test);
    }
}
