package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 * Represents a waste category entity for the waste sorting application.
 * This entity maps to the "waste_categories" table in the database.
 */
@Entity
@Table(name = "waste_categories")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates primary key
    private Integer id;

    @Column(nullable = false, unique = true) // Ensures "name" is not null and unique in the database
    @NotBlank(message = "Name cannot be blank") // Validates that "name" is not empty
    @Size(max = 100, message = "Name cannot exceed 100 characters") // Restricts "name" length
    private String name;

    @Column(length = 500) // Sets a maximum length for "description"
    private String description;

    @OneToMany(
            mappedBy = "wasteCategory",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    ) // Establishes a one-to-many relationship with DisposalGuideline
    private List<DisposalGuideline> disposalGuidelines;

    /**
     * Default constructor required by JPA.
     */
    public WasteCategory() {
    }

    /**
     * Parameterized constructor for creating a waste category with a name and description.
     *
     * @param name        the name of the waste category
     * @param description the description of the waste category
     */
    public WasteCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the unique identifier of the waste category.
     *
     * @return the unique identifier
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the waste category.
     *
     * @param id the unique identifier to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of the waste category.
     *
     * @return the name of the waste category
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the waste category.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the waste category.
     *
     * @return the description of the waste category
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the waste category.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the list of disposal guidelines associated with the waste category.
     *
     * @return the list of disposal guidelines
     */
    public List<DisposalGuideline> getDisposalGuidelines() {
        return disposalGuidelines;
    }

    /**
     * Sets the list of disposal guidelines for the waste category.
     *
     * @param disposalGuidelines the list of guidelines to associate
     */
    public void setDisposalGuidelines(List<DisposalGuideline> disposalGuidelines) {
        this.disposalGuidelines = disposalGuidelines;
    }
}
