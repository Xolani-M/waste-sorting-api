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
 * Represents a disposal guideline entity for the waste sorting application.
 * Maps to the "disposal_guidelines" table in the database.
 */
@Entity
@Table(name = "disposal_guidelines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class) // Enables auditing fields
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key
    private Long id;

    @Column(nullable = false, length = 500) // Ensures instruction is not null and limits its length
    @NotBlank(message = "Instruction cannot be blank")
    @Size(max = 500, message = "Instruction cannot exceed 500 characters")
    private String instruction;

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
     * Constructor for initializing a disposal guideline with an instruction and waste category.
     *
     * @param instruction   the disposal instruction
     * @param wasteCategory the associated waste category
     */
    public DisposalGuideline(String instruction, WasteCategory wasteCategory) {
        this.instruction = instruction;
        this.wasteCategory = wasteCategory;
    }
}
