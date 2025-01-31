package com.enviro.assessment.grad001.xolanimvana.dto;

import com.enviro.assessment.grad001.xolanimvana.config.CustomLocalDateTimeSerializer;
import com.enviro.assessment.grad001.xolanimvana.model.WasteCategory;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonPropertyOrder({ "id", "name", "description", "createdAt", "updatedAt", "disposalGuidelines", "recyclingTips" })
public class WasteCategoryDTO {
    private Long id;
    private String name;
    private String description;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class) // Custom serializer for ISO 8601 date formatting
    private LocalDateTime createdAt;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class) // Custom serializer for ISO 8601 date formatting
    private LocalDateTime updatedAt;

    private List<DisposalGuidelineDTO> disposalGuidelines;
    private List<RecyclingTipDTO> recyclingTips;

    public static WasteCategoryDTO fromEntity(WasteCategory category) {
        WasteCategoryDTO dto = new WasteCategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setCreatedAt(category.getCreatedAt());
        dto.setUpdatedAt(category.getUpdatedAt());

        // Populate disposal guidelines if they exist, otherwise set a default message
        if (category.getDisposalGuidelines() != null && !category.getDisposalGuidelines().isEmpty()) {
            dto.setDisposalGuidelines(category.getDisposalGuidelines().stream()
                    .map(DisposalGuidelineDTO::fromEntity)
                    .collect(Collectors.toList()));
        } else {
            dto.setDisposalGuidelines(List.of(DisposalGuidelineDTO.createDefault()));
        }

        // Populate recycling tips if they exist, otherwise set a default message
        if (category.getRecyclingTips() != null && !category.getRecyclingTips().isEmpty()) {
            dto.setRecyclingTips(category.getRecyclingTips().stream()
                    .map(RecyclingTipDTO::fromEntity)
                    .collect(Collectors.toList()));
        } else {
            dto.setRecyclingTips(List.of(RecyclingTipDTO.createDefault()));
        }

        return dto;
    }

    public WasteCategory toEntity() {
        WasteCategory category = new WasteCategory();
        category.setId(this.id);
        category.setName(this.name);
        category.setDescription(this.description);
        return category;
    }
}