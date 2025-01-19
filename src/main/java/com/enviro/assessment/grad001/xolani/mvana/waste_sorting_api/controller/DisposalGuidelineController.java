package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.controller;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing disposal guidelines.
 */
@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    @Autowired
    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    @GetMapping
    public ResponseEntity<List<DisposalGuidelineDTO>> getAllDisposalGuidelines() {
        List<DisposalGuidelineDTO> guidelines = disposalGuidelineService.getAllDisposalGuidelines();
        return ResponseEntity.ok(guidelines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> getDisposalGuidelineById(@PathVariable Integer id) {
        return disposalGuidelineService.getDisposalGuidelineById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DisposalGuidelineDTO> addDisposalGuideline(@RequestBody DisposalGuidelineDTO dto) {
        DisposalGuidelineDTO createdGuideline = disposalGuidelineService.addDisposalGuideline(dto);
        return ResponseEntity.ok(createdGuideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> updateDisposalGuideline(
            @PathVariable Integer id, @RequestBody DisposalGuidelineDTO dto) {
        return disposalGuidelineService.updateDisposalGuideline(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Integer id) {
        if (disposalGuidelineService.deleteDisposalGuideline(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
