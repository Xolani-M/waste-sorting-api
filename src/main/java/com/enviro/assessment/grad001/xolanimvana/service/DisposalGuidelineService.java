package com.enviro.assessment.grad001.xolanimvana.service;

import com.enviro.assessment.grad001.xolanimvana.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.xolanimvana.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.xolanimvana.model.DisposalGuideline;
import com.enviro.assessment.grad001.xolanimvana.model.WasteCategory;
import com.enviro.assessment.grad001.xolanimvana.repository.DisposalGuidelineRepo;
import com.enviro.assessment.grad001.xolanimvana.repository.WasteCategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepo disposalGuidelineRepo;
    private final WasteCategoryRepo wasteCategoryRepo;

    public DisposalGuidelineService(DisposalGuidelineRepo disposalGuidelineRepo, WasteCategoryRepo wasteCategoryRepo) {
        this.disposalGuidelineRepo = disposalGuidelineRepo;
        this.wasteCategoryRepo = wasteCategoryRepo;
    }

    public List<DisposalGuidelineDTO> getAllDisposalGuidelines() {
        return disposalGuidelineRepo.findAll().stream()
                .map(DisposalGuidelineDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public DisposalGuidelineDTO getDisposalGuidelineById(Long id) {
        DisposalGuideline guideline = disposalGuidelineRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline", id));
        return DisposalGuidelineDTO.fromEntity(guideline);
    }

    public DisposalGuidelineDTO addDisposalGuideline(DisposalGuidelineDTO dto) {
        WasteCategory wasteCategory = wasteCategoryRepo.findById(dto.getWasteCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory", dto.getWasteCategoryId()));

        DisposalGuideline guideline = dto.toEntity();
        guideline.setWasteCategory(wasteCategory);
        return DisposalGuidelineDTO.fromEntity(disposalGuidelineRepo.save(guideline));
    }

    public DisposalGuidelineDTO updateDisposalGuideline(Long id, DisposalGuidelineDTO dto) {
        DisposalGuideline guideline = disposalGuidelineRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline", id));

        guideline.setInstruction(dto.getInstruction());
        return DisposalGuidelineDTO.fromEntity(disposalGuidelineRepo.save(guideline));
    }

    public void deleteDisposalGuideline(Long id) {
        if (!disposalGuidelineRepo.existsById(id)) {
            throw new ResourceNotFoundException("DisposalGuideline", id);
        }
        disposalGuidelineRepo.deleteById(id);
    }
}
