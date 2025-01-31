package com.enviro.assessment.grad001.xolanimvana.dto;

import com.enviro.assessment.grad001.xolanimvana.model.RecyclingTip;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecyclingTipDTO {
    private Long id;
    private String tip;
    private String description;
    private Long wasteCategoryId;

    public static RecyclingTipDTO fromEntity(RecyclingTip entity) {
        return RecyclingTipDTO.builder()
                .id(entity.getId())
                .tip(entity.getTip())
                .description(entity.getDescription())
                .wasteCategoryId(entity.getWasteCategory().getId())
                .build();
    }

    public static RecyclingTipDTO createDefault() {
        return RecyclingTipDTO.builder()
                .tip("No tips available")
                .build();
    }

    public RecyclingTip toEntity() {
        RecyclingTip entity = new RecyclingTip();
        entity.setId(this.id);
        entity.setTip(this.tip);
        entity.setDescription(this.description);
        return entity;
    }
}