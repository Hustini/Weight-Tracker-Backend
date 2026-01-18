package org.hustini.weighttracker;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class WeightDTO {

    private String message;
    private Double weight;
    private Instant timestamp;

    public WeightDTO(String message, Double weight, Instant timestamp) {
        this.message = message;
        this.weight = weight;
        this.timestamp = timestamp;
    }
}
