package com.enviro.assessment.grad001.xolanimvana.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Represents a recycling tip entity for the waste sorting application.
 * Maps to the "recycling_tips" table in the database.
 */
@Entity
@Table(name = "recycling_tips")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class) // Enables auditing fields
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key
    private Long id;

    @Column(nullable = false, length = 255) // Ensures tip is not null and limits length
    @NotBlank(message = "Tip cannot be blank")
    @Size(max = 255, message = "Tip cannot exceed 255 characters")
    private String tip;

    @Column(length = 500) // Limits the maximum length for description
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY) // Fetch WasteCategory lazily to optimize performance
    @JoinColumn(name = "waste_category_id", nullable = false) // Foreign key linking to WasteCategory
    @JsonBackReference // Prevents infinite recursion when serializing
    private WasteCategory wasteCategory;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * Constructor for initializing a recycling tip with a tip, description, and waste category.
     *
     * @param tip          the main recycling tip
     * @param description  additional information or context
     * @param wasteCategory the associated waste category
     */
    public RecyclingTip(String tip, String description, WasteCategory wasteCategory) {
        this.tip = tip;
        this.description = description;
        this.wasteCategory = wasteCategory;
    }
}
