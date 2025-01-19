package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.service;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.WasteCategory;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.repository.WasteCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing waste categories.
 */
@Service
public class WasteCategoryService {

    private final WasteCategoryRepo wasteCategoryRepository;

    @Autowired
    public WasteCategoryService(WasteCategoryRepo wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    public Optional<WasteCategory> getWasteCategoryById(Integer id) {
        return wasteCategoryRepository.findById(id);
    }

    public WasteCategory addWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    public Optional<WasteCategory> updateWasteCategory(Integer id, WasteCategory updatedCategory) {
        return wasteCategoryRepository.findById(id).map(existingCategory -> {
            existingCategory.setName(updatedCategory.getName());
            existingCategory.setDescription(updatedCategory.getDescription());
            return wasteCategoryRepository.save(existingCategory);
        });
    }

    public boolean deleteWasteCategory(Integer id) {
        if (wasteCategoryRepository.existsById(id)) {
            wasteCategoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
