package org.hustini.weighttracker.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hustini.weighttracker.weight.Weight;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Weight> weights;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, List<Weight> weights) {
        this.username = username;
        this.weights = weights;
    }
}
