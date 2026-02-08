package org.hustini.weighttracker.user;

import lombok.Getter;
import lombok.Setter;
import org.hustini.weighttracker.weight.Weight;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private User username;
    private List<Weight> weights;

    public UserDTO(User username, List<Weight> weights) {
        this.username = username;
        this.weights = weights;
    }
}
