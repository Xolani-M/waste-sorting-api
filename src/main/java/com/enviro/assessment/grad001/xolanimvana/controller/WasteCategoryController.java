package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.controller;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.WasteCategory;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for managing waste categories.
 */
@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;

    @Autowired
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    /**
     * Retrieves all waste categories.
     *
     * @return List of WasteCategoryDTOs.
     */
    @GetMapping
    public ResponseEntity<List<WasteCategoryDTO>> getAllWasteCategories() {
        List<WasteCategoryDTO> categories = wasteCategoryService.getAllWasteCategories()
                .stream()
                .map(category -> WasteCategoryDTO.fromEntity(category)) // Using lambda for explicit clarity
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

    /**
     * Retrieves a specific waste category by its ID.
     *
     * @param id the ID of the waste category to retrieve.
     * @return WasteCategoryDTO if found, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> getWasteCategoryById(@PathVariable Integer id) {
        return wasteCategoryService.getWasteCategoryById(id)
                .map(category -> ResponseEntity.ok(WasteCategoryDTO.fromEntity(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new waste category.
     *
     * @param wasteCategoryDTO the waste category to create.
     * @return Created WasteCategoryDTO.
     */
    @PostMapping
    public ResponseEntity<WasteCategoryDTO> addWasteCategory(@RequestBody WasteCategoryDTO wasteCategoryDTO) {
        WasteCategory createdCategory = wasteCategoryService.addWasteCategory(wasteCategoryDTO.toEntity());
        return ResponseEntity.ok(WasteCategoryDTO.fromEntity(createdCategory));
    }

    /**
     * Updates an existing waste category.
     *
     * @param id               the ID of the waste category to update.
     * @param wasteCategoryDTO the updated waste category details.
     * @return Updated WasteCategoryDTO if successful, or 404 if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> updateWasteCategory(@PathVariable Integer id, @RequestBody WasteCategoryDTO wasteCategoryDTO) {
        return wasteCategoryService.updateWasteCategory(id, wasteCategoryDTO.toEntity())
                .map(updatedCategory -> ResponseEntity.ok(WasteCategoryDTO.fromEntity(updatedCategory))) // Lambda instead of method reference
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes a waste category by its ID.
     *
     * @param id the ID of the waste category to delete.
     * @return 204 No Content if successful, or 404 if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Integer id) {
        if (wasteCategoryService.deleteWasteCategory(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}