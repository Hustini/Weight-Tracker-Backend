package org.hustini.weighttracker;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightService {

    private final WeightRepository weightRepository;

    public WeightService(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    public List<Weight> getAllWeights() {
        return weightRepository.findAll();
    }

    public Weight addWeight(Double weightValue) {
        Weight weight = new Weight();
        weight.setWeight(weightValue);
        return weightRepository.save(weight);
    }
}
