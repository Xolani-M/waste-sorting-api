package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents a disposal guideline entity for the waste sorting application.
 * Maps to the "disposal_guidelines" table in the database.
 */
@Entity
@Table(name = "disposal_guidelines")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the primary key
    private Integer id;

    @Column(nullable = false) // Ensures the "instruction" column is not null
    @NotBlank(message = "Instruction cannot be blank") // Validates that "instruction" is not empty or null
    private String instruction;

    @ManyToOne(fetch = FetchType.LAZY) // Fetch WasteCategory lazily to optimize performance
    @JoinColumn(name = "waste_category_id", nullable = false) // Foreign key linking to WasteCategory
    private WasteCategory wasteCategory;

    /**
     * Default constructor required by JPA.
     */
    public DisposalGuideline() {
    }

    /**
     * Parameterized constructor for initializing with an instruction.
     *
     * @param instruction the disposal instruction
     */
    public DisposalGuideline(String instruction) {
        this.instruction = instruction;
    }

    // Getters and Setters

    /**
     * Gets the unique identifier of the disposal guideline.
     *
     * @return the unique identifier
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the disposal guideline.
     *
     * @param id the unique identifier to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the disposal instruction.
     *
     * @return the disposal instruction
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * Sets the disposal instruction.
     *
     * @param instruction the disposal instruction to set
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    /**
     * Gets the associated waste category for the disposal guideline.
     *
     * @return the associated WasteCategory
     */
    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    /**
     * Sets the associated waste category for the disposal guideline.
     *
     * @param wasteCategory the WasteCategory to associate
     */
    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}
