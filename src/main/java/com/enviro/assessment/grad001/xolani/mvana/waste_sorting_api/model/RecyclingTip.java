package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents a recycling tip entity for the waste sorting application.
 * Maps to the "recycling_tips" table in the database.
 */
@Entity
@Table(name = "recycling_tips")
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key
    private Integer id;

    @Column(nullable = false) // Ensures "tip" is not null
    @NotBlank(message = "Tip cannot be blank") // Validates non-blank input
    @Size(max = 255, message = "Tip cannot exceed 255 characters") // Restricts length
    private String tip;

    @Column(length = 500) // Limits the maximum length for "description"
    @Size(max = 500, message = "Description cannot exceed 500 characters") // Validates length
    private String description;

    // Default constructor required by JPA
    public RecyclingTip() {}

    /**
     * Parameterized constructor for initializing RecyclingTip.
     *
     * @param tip         the main recycling tip
     * @param description additional information or context
     */
    public RecyclingTip(String tip, String description) {
        this.tip = tip;
        this.description = description;
    }

    // Getters and Setters

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
