package org.hustini.weighttracker;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeightRequestDTO {

    @NotNull
    @Positive
    private Double weight;

    public Double getWeight() {
        return weight;
    }
}
