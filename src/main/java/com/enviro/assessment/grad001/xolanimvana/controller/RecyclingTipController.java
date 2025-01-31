package com.enviro.assessment.grad001.xolanimvana.controller;

import com.enviro.assessment.grad001.xolanimvana.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.xolanimvana.service.RecyclingTipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Recycling Tips.
 */
@RestController
@RequestMapping("/api/recycling-tips")
@RequiredArgsConstructor
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    /**
     * Retrieves all recycling tips.
     *
     * @return List of RecyclingTipDTOs.
     */
    @GetMapping
    public ResponseEntity<List<RecyclingTipDTO>> getAllRecyclingTips() {
        return ResponseEntity.ok(recyclingTipService.getAllRecyclingTips());
    }

    /**
     * Retrieves a specific recycling tip by its ID.
     *
     * @param id the ID of the recycling tip to retrieve.
     * @return RecyclingTipDTO if found, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> getRecyclingTipById(@PathVariable Long id) {
        return ResponseEntity.ok(recyclingTipService.getRecyclingTipById(id));
    }

    /**
     * Creates a new recycling tip.
     *
     * @param recyclingTipDTO the recycling tip to create.
     * @return Created RecyclingTipDTO.
     */
    @PostMapping
    public ResponseEntity<RecyclingTipDTO> addRecyclingTip(@RequestBody RecyclingTipDTO recyclingTipDTO) {
        RecyclingTipDTO createdTip = recyclingTipService.addRecyclingTip(recyclingTipDTO);
        return ResponseEntity.ok(createdTip);
    }

    /**
     * Updates an existing recycling tip.
     *
     * @param id              the ID of the recycling tip to update.
     * @param recyclingTipDTO the updated recycling tip details.
     * @return Updated RecyclingTipDTO if successful, or 404 if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> updateRecyclingTip(@PathVariable Long id, @RequestBody RecyclingTipDTO recyclingTipDTO) {
        return ResponseEntity.ok(recyclingTipService.updateRecyclingTip(id, recyclingTipDTO));
    }

    /**
     * Deletes a recycling tip by its ID.
     *
     * @param id the ID of the recycling tip to delete.
     * @return 204 No Content if successful, or 404 if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }
}
