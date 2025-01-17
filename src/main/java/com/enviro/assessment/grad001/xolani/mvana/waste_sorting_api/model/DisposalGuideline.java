package com.enviro.assessment.grad001.xolanimvana.model;

import jakarta.persistence.*;

/**
 * Represents a disposal guideline entity for the application.
 * This class maps to a database table using JPA annotations.
 */
@Entity
@Table(name = "disposal_guidelines")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String instruction;

    @ManyToOne
    @JoinColumn(name = "waste_category_id", nullable = false)
    private WasteCategory wasteCategory;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}
