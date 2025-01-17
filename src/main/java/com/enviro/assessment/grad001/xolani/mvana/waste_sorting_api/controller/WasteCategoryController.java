package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.controller;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.WasteCategory;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling HTTP requests related to waste categories.
 * Provides CRUD operations for managing waste categories in the system.
 */
@RestController
@RequestMapping("/api/waste-category")
public class WasteCategoryCtrl {

    private final WasteCategoryService wasteCategoryService;

    /**
     * Constructor for injecting WasteCategoryService.
     *
     * @param wasteCategoryService The service for managing waste categories.
     */
    @Autowired
    public WasteCategoryCtrl(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    /**
     * Retrieves all waste categories.
     *
     * @return A list of all waste categories.
     */
    @GetMapping
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryService.getAllWasteCategories();
    }

    /**
     * Retrieves a specific waste category by its ID.
     *
     * @param id The ID of the waste category to retrieve.
     * @return ResponseEntity containing the waste category if found, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        return wasteCategoryService.getWasteCategoryById(id)
                .map(category -> ResponseEntity.ok(category))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new waste category.
     *
     * @param wasteCategory The waste category to create.
     * @return The created waste category.
     */
    @PostMapping
    public WasteCategory createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        return wasteCategoryService.createWasteCategory(wasteCategory);
    }

    /**
     * Updates an existing waste category by its ID.
     *
     * @param id The ID of the waste category to update.
     * @param wasteCategory The updated waste category details.
     * @return ResponseEntity containing the updated waste category if found, or 404 if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(
            @PathVariable Long id, @RequestBody WasteCategory wasteCategory) {
        return wasteCategoryService.updateWasteCategory(id, wasteCategory)
                .map(category -> ResponseEntity.ok(category))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes a specific waste category by its ID.
     *
     * @param id The ID of the waste category to delete.
     * @return ResponseEntity with 204 status if deleted, or 404 if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        if (wasteCategoryService.deleteWasteCategory(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
