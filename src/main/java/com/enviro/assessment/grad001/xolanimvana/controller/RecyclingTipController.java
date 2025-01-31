package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.controller;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService service;

    public RecyclingTipController(RecyclingTipService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RecyclingTipDTO> createTip(@Valid @RequestBody RecyclingTipDTO recyclingTipDTO) {
        return new ResponseEntity<>(service.createRecyclingTip(recyclingTipDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> updateTip(
            @PathVariable Integer id,
            @Valid @RequestBody RecyclingTipDTO recyclingTipDTO
    ) {
        return ResponseEntity.ok(service.updateRecyclingTip(id, recyclingTipDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> getTipById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getRecyclingTipById(id));
    }

    @GetMapping
    public ResponseEntity<List<RecyclingTipDTO>> getAllTips() {
        return ResponseEntity.ok(service.getAllRecyclingTips());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Integer id) {
        service.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }
}
