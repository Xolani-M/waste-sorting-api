package com.enviro.assessment.grad001.xolanimvana.waste_sorting_api.controller;

import com.enviro.assessment.grad001.xolanimvana.waste_sorting_api.model.DisposalGuideline;
import com.enviro.assessment.grad001.xolanimvana.waste_sorting_api.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing disposal guidelines.
 * Provides endpoints for CRUD operations on disposal guidelines in the system.
 */
@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    /**
     * Constructor for injecting the DisposalGuidelineService.
     *
     * @param disposalGuidelineService the service for managing disposal guidelines.
     */
    @Autowired
    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    /**
     * Retrieves all disposal guidelines.
     *
     * @return ResponseEntity containing a list of all disposal guidelines.
     */
    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuidelines() {
        List<DisposalGuideline> guidelines = disposalGuidelineService.getAllDisposalGuidelines();
        return ResponseEntity.ok(guidelines);
    }

    /**
     * Retrieves a specific disposal guideline by its ID.
     *
     * @param id the ID of the disposal guideline to retrieve.
     * @return ResponseEntity containing the disposal guideline if found, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {
        return disposalGuidelineService.getDisposalGuidelineById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new disposal guideline.
     *
     * @param disposalGuideline the disposal guideline to create.
     * @return ResponseEntity containing the created disposal guideline.
     */
    @PostMapping
    public ResponseEntity<DisposalGuideline> addDisposalGuideline(@RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline createdGuideline = disposalGuidelineService.addDisposalGuideline(disposalGuideline);
        return ResponseEntity.ok(createdGuideline);
    }

    /**
     * Updates an existing disposal guideline.
     *
     * @param id               the ID of the disposal guideline to update.
     * @param disposalGuideline the updated disposal guideline details.
     * @return ResponseEntity containing the updated disposal guideline if found, or 404 if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(
            @PathVariable Long id, @RequestBody DisposalGuideline disposalGuideline) {
        return disposalGuidelineService.updateDisposalGuideline(id, disposalGuideline)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes a disposal guideline by its ID.
     *
     * @param id the ID of the disposal guideline to delete.
     * @return ResponseEntity with the result of the deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        if (disposalGuidelineService.deleteDisposalGuideline(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
