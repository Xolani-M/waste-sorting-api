package com.enviro.assessment.grad001.xolanimvana.dto;

import com.enviro.assessment.grad001.xolanimvana.model.DisposalGuideline;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DisposalGuidelineDTO {
    private Long id;
    private String instruction;
    private Long wasteCategoryId;
    private String guideline;

    public static DisposalGuidelineDTO fromEntity(DisposalGuideline entity) {
        return DisposalGuidelineDTO.builder()
                .id(entity.getId())
                .instruction(entity.getInstruction())
                .wasteCategoryId(entity.getWasteCategory().getId())
                .guideline(entity.getGuideline()) // Use the new guideline field
                .build();
    }

    public static DisposalGuidelineDTO createDefault() {
        return DisposalGuidelineDTO.builder()
                .guideline("No guidelines available")
                .build();
    }

    public DisposalGuideline toEntity() {
        DisposalGuideline entity = new DisposalGuideline();
        entity.setId(this.id);
        entity.setInstruction(this.instruction);
        entity.setGuideline(this.guideline);
        return entity;
    }
}