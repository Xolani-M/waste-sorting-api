package com.enviro.assessment.grad001.xolanimvana.controller;

import com.enviro.assessment.grad001.xolanimvana.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.xolanimvana.service.WasteCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;

    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<WasteCategoryDTO>> getAllWasteCategories() {
        return ResponseEntity.ok(wasteCategoryService.getAllWasteCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> getWasteCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(wasteCategoryService.getWasteCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<WasteCategoryDTO> createWasteCategory(@RequestBody WasteCategoryDTO wasteCategoryDTO) {
        return ResponseEntity.ok(wasteCategoryService.createWasteCategory(wasteCategoryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> updateWasteCategory(
            @PathVariable Long id, @RequestBody WasteCategoryDTO wasteCategoryDTO) {
        return ResponseEntity.ok(wasteCategoryService.updateWasteCategory(id, wasteCategoryDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
