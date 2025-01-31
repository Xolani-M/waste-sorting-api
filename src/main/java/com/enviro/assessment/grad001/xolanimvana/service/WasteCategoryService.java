package com.enviro.assessment.grad001.xolanimvana.service;

import com.enviro.assessment.grad001.xolanimvana.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.xolanimvana.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.xolanimvana.model.WasteCategory;
import com.enviro.assessment.grad001.xolanimvana.repository.WasteCategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WasteCategoryService {

    private final WasteCategoryRepo wasteCategoryRepo;

    @Transactional(readOnly = true)
    public List<WasteCategoryDTO> getAllWasteCategories() {
        return wasteCategoryRepo.findAll().stream()
                .map(WasteCategoryDTO::fromEntity)
                .toList(); // More efficient than `collect(Collectors.toList())`
    }

    @Transactional(readOnly = true)
    public WasteCategoryDTO getWasteCategoryById(Long id) {
        WasteCategory category = wasteCategoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory", id));
        return WasteCategoryDTO.fromEntity(category);
    }

    @Transactional
    public WasteCategoryDTO createWasteCategory(WasteCategoryDTO wasteCategoryDTO) {
        WasteCategory category = wasteCategoryDTO.toEntity();
        WasteCategory savedCategory = wasteCategoryRepo.save(category);
        return WasteCategoryDTO.fromEntity(savedCategory);
    }

    @Transactional
    public WasteCategoryDTO updateWasteCategory(Long id, WasteCategoryDTO wasteCategoryDTO) {
        WasteCategory category = wasteCategoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory", id));

        category.setName(wasteCategoryDTO.getName());
        category.setDescription(wasteCategoryDTO.getDescription());

        return WasteCategoryDTO.fromEntity(wasteCategoryRepo.save(category));
    }

    @Transactional
    public void deleteWasteCategory(Long id) {
        if (!wasteCategoryRepo.existsById(id)) {
            throw new ResourceNotFoundException("WasteCategory", id);
        }
        wasteCategoryRepo.deleteById(id);
    }
}
