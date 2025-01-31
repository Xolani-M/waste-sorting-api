package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.service;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.RecyclingTip;
import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.repository.RecyclingTipRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecyclingTipService {

    private final RecyclingTipRepo repository;

    public RecyclingTipService(RecyclingTipRepo repository) {
        this.repository = repository;
    }

    public RecyclingTipDTO createRecyclingTip(RecyclingTipDTO recyclingTipDTO) {
        RecyclingTip tip = new RecyclingTip(recyclingTipDTO.getTip(), recyclingTipDTO.getDescription());
        RecyclingTip savedTip = repository.save(tip);
        return mapToDTO(savedTip);
    }

    public RecyclingTipDTO updateRecyclingTip(Integer id, RecyclingTipDTO recyclingTipDTO) {
        RecyclingTip tip = repository.findById(id).orElseThrow(() -> new RuntimeException("Tip not found"));
        tip.setTip(recyclingTipDTO.getTip());
        tip.setDescription(recyclingTipDTO.getDescription());
        RecyclingTip updatedTip = repository.save(tip);
        return mapToDTO(updatedTip);
    }

    public void deleteRecyclingTip(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Tip not found");
        }
        repository.deleteById(id);
    }

    public RecyclingTipDTO getRecyclingTipById(Integer id) {
        RecyclingTip tip = repository.findById(id).orElseThrow(() -> new RuntimeException("Tip not found"));
        return mapToDTO(tip);
    }

    public List<RecyclingTipDTO> getAllRecyclingTips() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private RecyclingTipDTO mapToDTO(RecyclingTip tip) {
        RecyclingTipDTO dto = new RecyclingTipDTO();
        dto.setId(tip.getId());
        dto.setTip(tip.getTip());
        dto.setDescription(tip.getDescription());
        return dto;
    }
}
