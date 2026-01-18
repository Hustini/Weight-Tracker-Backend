package org.hustini.weighttracker;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weights")
public class WeightController {

    private final WeightService weightService;

    public WeightController(WeightService weightService) {
        this.weightService = weightService;
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
