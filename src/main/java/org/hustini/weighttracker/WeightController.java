package org.hustini.weighttracker;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/weights")
public class WeightController {

    private final WeightService weightService;

    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @GetMapping
    public ResponseEntity<?> getAllWeights() {

        List<Weight> weights = weightService.getAllWeights();

        List<WeightDTO> response = weights.stream()
                .map(weight -> new WeightDTO(
                        "Weight entry retrieved successfully",
                        weight.getWeight(),
                        weight.getTimestamp()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> addWeight(@RequestBody @Valid WeightRequestDTO request) {
        Weight savedWeight = weightService.addWeight(request.getWeight());

        WeightDTO response = new WeightDTO(
                "Weight entry added successfully",
                savedWeight.getWeight(),
                savedWeight.getTimestamp()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
