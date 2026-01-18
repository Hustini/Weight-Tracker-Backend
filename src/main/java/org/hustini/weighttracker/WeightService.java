package org.hustini.weighttracker;

import org.springframework.stereotype.Service;

@Service
public class WeightService {

    private final WeightRepository weightRepository;

    public WeightService(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    public Weight addWeight(Double weightValue) {
        Weight weight = new Weight();
        weight.setWeight(weightValue);
        return weightRepository.save(weight);
    }
}
