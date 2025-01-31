package com.enviro.assessment.grad001.xolanimvana.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a waste category entity for the waste sorting application.
 */
@Entity
@Table(name = "waste_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @Column(length = 500)
    private String description;

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<DisposalGuideline> disposalGuidelines = new ArrayList<>();

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<RecyclingTip> recyclingTips = new ArrayList<>();

    /**
     * Constructor for creating a waste category with name and description.
     */
    public WasteCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Helper method to add a disposal guideline and maintain bidirectional relationship.
     */
    public void addDisposalGuideline(DisposalGuideline guideline) {
        disposalGuidelines.add(guideline);
        guideline.setWasteCategory(this);
    }

    /**
     * Helper method to remove a disposal guideline and maintain bidirectional relationship.
     */
    public void removeDisposalGuideline(DisposalGuideline guideline) {
        disposalGuidelines.remove(guideline);
        guideline.setWasteCategory(null);
    }

    /**
     * Helper method to add a recycling tip and maintain bidirectional relationship.
     */
    public void addRecyclingTip(RecyclingTip tip) {
        recyclingTips.add(tip);
        tip.setWasteCategory(this);
    }

    /**
     * Helper method to remove a recycling tip and maintain bidirectional relationship.
     */
    public void removeRecyclingTip(RecyclingTip tip) {
        recyclingTips.remove(tip);
        tip.setWasteCategory(null);
    }
}