package com.enviro.assessment.grad001.xolanimvana.service;

import com.enviro.assessment.grad001.xolanimvana.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.xolanimvana.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.xolanimvana.model.RecyclingTip;
import com.enviro.assessment.grad001.xolanimvana.model.WasteCategory;
import com.enviro.assessment.grad001.xolanimvana.repository.RecyclingTipRepo;
import com.enviro.assessment.grad001.xolanimvana.repository.WasteCategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer for managing Recycling Tips.
 */
@Service
@RequiredArgsConstructor
public class RecyclingTipService {

    private final RecyclingTipRepo recyclingTipRepo;
    private final WasteCategoryRepo wasteCategoryRepo;

    /**
     * Retrieves all recycling tips.
     *
     * @return List of RecyclingTipDTOs.
     */
    public List<RecyclingTipDTO> getAllRecyclingTips() {
        return recyclingTipRepo.findAll().stream()
                .map(RecyclingTipDTO::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a specific recycling tip by its ID.
     *
     * @param id the ID of the recycling tip.
     * @return RecyclingTipDTO if found.
     * @throws ResourceNotFoundException if the tip does not exist.
     */
    public RecyclingTipDTO getRecyclingTipById(Long id) {
        RecyclingTip tip = recyclingTipRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip", id));
        return RecyclingTipDTO.fromEntity(tip);
    }

    /**
     * Creates a new recycling tip.
     *
     * @param dto the RecyclingTipDTO containing tip details.
     * @return Created RecyclingTipDTO.
     * @throws ResourceNotFoundException if the waste category is not found.
     */
    public RecyclingTipDTO addRecyclingTip(RecyclingTipDTO dto) {
        WasteCategory wasteCategory = wasteCategoryRepo.findById(dto.getWasteCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory", dto.getWasteCategoryId()));

        RecyclingTip tip = dto.toEntity();
        tip.setWasteCategory(wasteCategory);
        return RecyclingTipDTO.fromEntity(recyclingTipRepo.save(tip));
    }

    /**
     * Updates an existing recycling tip.
     *
     * @param id  the ID of the tip to update.
     * @param dto the updated RecyclingTipDTO.
     * @return Updated RecyclingTipDTO.
     * @throws ResourceNotFoundException if the tip or waste category is not found.
     */
    public RecyclingTipDTO updateRecyclingTip(Long id, RecyclingTipDTO dto) {
        RecyclingTip tip = recyclingTipRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip", id));

        WasteCategory wasteCategory = wasteCategoryRepo.findById(dto.getWasteCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory", dto.getWasteCategoryId()));

        tip.setTip(dto.getTip());
        tip.setDescription(dto.getDescription());
        tip.setWasteCategory(wasteCategory);

        return RecyclingTipDTO.fromEntity(recyclingTipRepo.save(tip));
    }

    /**
     * Deletes a recycling tip by ID.
     *
     * @param id the ID of the tip to delete.
     * @throws ResourceNotFoundException if the tip does not exist.
     */
    public void deleteRecyclingTip(Long id) {
        if (!recyclingTipRepo.existsById(id)) {
            throw new ResourceNotFoundException("RecyclingTip", id);
        }
        recyclingTipRepo.deleteById(id);
    }
}
