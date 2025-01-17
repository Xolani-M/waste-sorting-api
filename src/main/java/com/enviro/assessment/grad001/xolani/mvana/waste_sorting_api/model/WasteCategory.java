package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.DisposalGuideline;
import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a waste category entity for the waste sorting application.
 * This class maps to a database table using JPA annotations.
 */


@Entity
@Table(name = "waste_categories") 
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates primary key
    private Long id;

    @Column(nullable = false, unique = true) // Ensures name is not null and unique
    private String name;

    @Column(length = 500) // Allows a longer description
    private String description;

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisposalGuideline> disposalGuidelines;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<DisposalGuideline> getDisposalGuidelines() {
        return disposalGuidelines;
    }

    public void setDisposalGuidelines(List<DisposalGuideline> disposalGuidelines) {
        this.disposalGuidelines = disposalGuidelines;
    }
}
