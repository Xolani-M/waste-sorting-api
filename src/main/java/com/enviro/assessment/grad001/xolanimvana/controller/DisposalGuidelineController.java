package com.enviro.assessment.grad001.xolanimvana.controller;

import com.enviro.assessment.grad001.xolanimvana.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.xolanimvana.service.DisposalGuidelineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    @GetMapping
    public ResponseEntity<List<DisposalGuidelineDTO>> getAllDisposalGuidelines() {
        return ResponseEntity.ok(disposalGuidelineService.getAllDisposalGuidelines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> getDisposalGuidelineById(@PathVariable Long id) {
        return ResponseEntity.ok(disposalGuidelineService.getDisposalGuidelineById(id));
    }

    @PostMapping
    public ResponseEntity<DisposalGuidelineDTO> addDisposalGuideline(@RequestBody DisposalGuidelineDTO dto) {
        return ResponseEntity.ok(disposalGuidelineService.addDisposalGuideline(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> updateDisposalGuideline(@PathVariable Long id, @RequestBody DisposalGuidelineDTO dto) {
        return ResponseEntity.ok(disposalGuidelineService.updateDisposalGuideline(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
