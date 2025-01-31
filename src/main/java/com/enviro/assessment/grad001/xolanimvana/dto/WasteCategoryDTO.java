package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.dto;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.WasteCategory;

/**
 * Data Transfer Object for WasteCategory.
 */
public class WasteCategoryDTO {

    private Integer id;
    private String name;
    private String description;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Conversion Methods
    public static WasteCategoryDTO fromEntity(WasteCategory entity) {
        WasteCategoryDTO dto = new WasteCategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public WasteCategory toEntity() {
        WasteCategory entity = new WasteCategory();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setDescription(this.description);
        return entity;
    }
}
