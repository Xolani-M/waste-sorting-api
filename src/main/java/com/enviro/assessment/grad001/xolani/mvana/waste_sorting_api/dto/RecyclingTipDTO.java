package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RecyclingTipDTO {

    private Integer id;

    @NotBlank(message = "Tip cannot be blank")
    @Size(max = 255, message = "Tip cannot exceed 255 characters")
    private String tip;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
