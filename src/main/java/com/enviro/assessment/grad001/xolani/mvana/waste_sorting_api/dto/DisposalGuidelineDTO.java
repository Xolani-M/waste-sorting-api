package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.dto;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.DisposalGuideline;

public class DisposalGuidelineDTO {

    private Integer id;
    private String instruction;
    private Integer wasteCategoryId;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Integer getWasteCategoryId() {
        return wasteCategoryId;
    }

    public void setWasteCategoryId(Integer wasteCategoryId) {
        this.wasteCategoryId = wasteCategoryId;
    }

    // Conversion Methods
    public static DisposalGuidelineDTO fromEntity(DisposalGuideline entity) {
        DisposalGuidelineDTO dto = new DisposalGuidelineDTO();
        dto.setId(entity.getId());
        dto.setInstruction(entity.getInstruction());
        if (entity.getWasteCategory() != null) {
            dto.setWasteCategoryId(entity.getWasteCategory().getId());
        }
        return dto;
    }

    public DisposalGuideline toEntity() {
        DisposalGuideline entity = new DisposalGuideline();
        entity.setId(this.id);
        entity.setInstruction(this.instruction);
        return entity;
    }
}
