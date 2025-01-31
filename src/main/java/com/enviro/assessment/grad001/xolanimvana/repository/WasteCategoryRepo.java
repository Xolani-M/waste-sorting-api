package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.repository;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepo extends JpaRepository<WasteCategory, Integer> {

}
