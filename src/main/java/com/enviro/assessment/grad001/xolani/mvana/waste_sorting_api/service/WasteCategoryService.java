package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.service;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.WasteCategory;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.repository.WasteCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    @Autowired
    WasteCategoryRepo wasteCategoryRepo;


    /**
     * Retrieve all waste categories.
     * @return a list of waste categories.
     */
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepo.findAll();
    }

    /**
     * Adds a new waste category.
     *
     * @param wasteCategory the waste category to add.
     * @return the saved WasteCategory.
     */
    public WasteCategory addWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepo.save(wasteCategory);
    }


    /**
     * Retrieve a waste category by its ID.
     *
     * @param id the ID of the waste category to retrieve.
     * @return the WasteCategory if found, or null if not found.
     */
    public WasteCategory getWasteCategoryById(int id) {
        return wasteCategoryRepo.findById(id).orElse(new WasteCategory());
    }


    /**
     * Updates an existing waste category.
     *
     * @param updatedCategory the updated waste category details.
     * @return the updated WasteCategory or null if not found.
     */
    public WasteCategory updateWasteCategory(WasteCategory updatedCategory) {
        if (wasteCategoryRepo.existsById(updatedCategory.getId())) {
            return wasteCategoryRepo.save(updatedCategory);
        }
        return null;
    }


    /**
     * Deletes a waste category by its ID.
     *
     * @param id the ID of the waste category to delete.
     * @return true if the category was deleted, false otherwise.
     */
    public boolean deleteWasteCategory(int id) {
        if (wasteCategoryRepo.existsById(id)) {
            wasteCategoryRepo.deleteById(id);
            return true;
        }
        return false;
    }



}
