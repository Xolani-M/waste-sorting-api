package com.enviro.assessment.grad001.xolanimvana.repository;

import com.enviro.assessment.grad001.xolanimvana.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepo extends JpaRepository<WasteCategory, Long> {

}
