package com.enviro.assessment.grad001.xolanimvana.repository;

import com.enviro.assessment.grad001.xolanimvana.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing disposal guideline entities in the database.
 */
@Repository
public interface DisposalGuidelineRepo extends JpaRepository<DisposalGuideline, Long> {
}
