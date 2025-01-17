package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.service;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.WasteCategory;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.ArrayList;

@Service
public class WasteCategoryService {

    private final List<WasteCategory> wasteCategories = new ArrayList<>();

    /**
     * Initialize dummy data for testing.
     */
    @PostConstruct
    public void initializeDummyData() {
        WasteCategory plastic = new WasteCategory();
        plastic.setId(1L);
        plastic.setName("Plastic");
        plastic.setDescription("Plastic waste including bottles, bags, and packaging.");
//        plastic.setDisposalGuidelines(Arrays.asList(
//                new DisposalGuideline("Recycle at designated centers"),
//                new DisposalGuideline("Avoid burning plastic as it releases toxic fumes")
//        ));

        WasteCategory organic = new WasteCategory();
        organic.setId(2L);
        organic.setName("Organic");
        organic.setDescription("Organic waste including food scraps, garden waste, and other compostable materials.");
//        organic.setDisposalGuidelines(Arrays.asList(
//                new DisposalGuideline("Compost at home or in community compost bins"),
//                new DisposalGuideline("Avoid mixing with non-biodegradable materials")
//        ));

        WasteCategory metal = new WasteCategory();
        metal.setId(3L);
        metal.setName("Metal");
        metal.setDescription("Metal waste including cans, scrap metal, and aluminum products.");
//        metal.setDisposalGuidelines(Arrays.asList(
//                new DisposalGuideline("Recycle at scrap metal centers"),
//                new DisposalGuideline("Clean metal waste before recycling")
//        ));

        wasteCategories.add(plastic);
        wasteCategories.add(organic);
        wasteCategories.add(metal);

    }

    /**
     * Retrieve all waste categories.
     * @return a list of waste categories.
     */
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategories;
    }

    /**
     * Add a new waste category.
     * @param wasteCategory the waste category to add.
     */
    public void addWasteCategory(WasteCategory wasteCategory) {
        wasteCategories.add(wasteCategory);
    }


    /**
     * Retrieve a waste category by its ID.
     *
     * @param id the ID of the waste category to retrieve.
     * @return the WasteCategory if found, or null if not found.
     */
    public WasteCategory getWasteCategoryById(Long id) {
        return wasteCategories.stream()
                .filter(category -> category.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    /**
     * Updates an existing waste category.
     *
     * @param updatedCategory the updated waste category details.
     * @return the updated WasteCategory if found, or null if not found.
     */
    public WasteCategory updateWasteCategory(WasteCategory updatedCategory) {
        // Check for null or empty values
        if (updatedCategory == null || updatedCategory.getId() == null) {
            throw new IllegalArgumentException("Updated category and ID cannot be null");
        }

        return wasteCategories.stream()
                .filter(category -> category.getId().equals(updatedCategory.getId()))
                .findFirst()
                .map(category -> {
                    category.setName(updatedCategory.getName());
                    category.setDescription(updatedCategory.getDescription());
                    return category;
                })
                .orElse(null);
    }


    /**
     * Deletes a waste category by its ID.
     *
     * @param id the ID of the waste category to delete.
     * @return true if the category was deleted, false if not found.
     */
    public boolean deleteWasteCategory(Long id) {
        return wasteCategories.removeIf(category -> category.getId().equals(id));
    }



}
