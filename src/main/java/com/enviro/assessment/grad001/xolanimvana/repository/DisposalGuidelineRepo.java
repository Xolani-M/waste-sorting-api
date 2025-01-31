package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.repository;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing disposal guideline entities in the database.
 */
@Repository
public interface DisposalGuidelineRepo extends JpaRepository<DisposalGuideline, Integer> {
}
