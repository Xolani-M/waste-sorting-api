package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.controller;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.WasteCategory;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing waste categories.
 * Provides endpoints for CRUD operations on waste categories in the system.
 */
@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {


    private final WasteCategoryService wasteCategoryService;

    /**
     * Constructor for injecting the WasteCategoryService.
     *
     * @param wasteCategoryService the service for managing waste categories.
     */
    @Autowired
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    /**
     * Retrieves all waste categories.
     *
     * @return ResponseEntity containing a list of all waste categories.
     */
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        List<WasteCategory> categories = wasteCategoryService.getAllWasteCategories();
        return ResponseEntity.ok(categories);
    }



    /**
     * Retrieves a specific waste category by its ID.
     *
     * @param id the ID of the waste category to retrieve.
     * @return ResponseEntity containing the waste category if found, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        WasteCategory category = wasteCategoryService.getWasteCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Creates a new waste category.
     *
     * @param wasteCategory the waste category to create.
     * @return ResponseEntity containing the created waste category.
     */
    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        wasteCategoryService.addWasteCategory(wasteCategory); // Use addWasteCategory from the service
        return ResponseEntity.ok(wasteCategory);
    }

    /**
     * Updates an existing waste category.
     *
     * @param wasteCategory the updated waste category details.
     * @return ResponseEntity containing the updated waste category if found, or 404 if not found.
     */
    @PutMapping
    public ResponseEntity<WasteCategory> updateWasteCategory(@RequestBody WasteCategory wasteCategory) {
        // Call the service method to update the category
        WasteCategory updatedCategory = wasteCategoryService.updateWasteCategory(wasteCategory);

        // Return a ResponseEntity with the updated category or a 404 status
        return updatedCategory != null
                ? ResponseEntity.ok(updatedCategory)
                : ResponseEntity.notFound().build();
    }


//    /**
//     * Deletes a specific waste category by its ID.
//     *
//     * @param id the ID of the waste category to delete.
//     * @return ResponseEntity with a 204 status if deleted, or 404 if not found.
//     */
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
//        boolean isDeleted = wasteCategoryService.deleteWasteCategory(id);
//        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWasteCategory(@PathVariable Long id) {
        boolean isDeleted = wasteCategoryService.deleteWasteCategory(id);
        if (isDeleted) {
            return ResponseEntity.ok("Waste category with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
