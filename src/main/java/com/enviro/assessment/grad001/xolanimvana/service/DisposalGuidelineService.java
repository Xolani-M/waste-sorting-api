package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.service;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.DisposalGuideline;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.repository.DisposalGuidelineRepo;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.repository.WasteCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepo repository;
    private final WasteCategoryRepo wasteCategoryRepo;

    @Autowired
    public DisposalGuidelineService(DisposalGuidelineRepo repository, WasteCategoryRepo wasteCategoryRepo) {
        this.repository = repository;
        this.wasteCategoryRepo = wasteCategoryRepo;
    }

    public List<DisposalGuidelineDTO> getAllDisposalGuidelines() {
        return repository.findAll().stream()
                .map(DisposalGuidelineDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<DisposalGuidelineDTO> getDisposalGuidelineById(Integer id) {
        return repository.findById(id)
                .map(DisposalGuidelineDTO::fromEntity);
    }

    public DisposalGuidelineDTO addDisposalGuideline(DisposalGuidelineDTO dto) {
        DisposalGuideline guideline = dto.toEntity();
        wasteCategoryRepo.findById(dto.getWasteCategoryId()).ifPresent(guideline::setWasteCategory);
        return DisposalGuidelineDTO.fromEntity(repository.save(guideline));
    }

    public Optional<DisposalGuidelineDTO> updateDisposalGuideline(Integer id, DisposalGuidelineDTO dto) {
        return repository.findById(id).map(existing -> {
            existing.setInstruction(dto.getInstruction());
            wasteCategoryRepo.findById(dto.getWasteCategoryId()).ifPresent(existing::setWasteCategory);
            return DisposalGuidelineDTO.fromEntity(repository.save(existing));
        });
    }

    public boolean deleteDisposalGuideline(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
