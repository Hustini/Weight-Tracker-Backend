package org.hustini.weighttracker.weight;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;
import org.hustini.weighttracker.user.User;

@Entity
@Getter
@Setter
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double weight;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant timestamp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public Weight() {
    }

    public Weight(User user, Double weight) {
        this.user = user;
        this.weight = weight;
    }
}
