package com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.repository;

import com.enviro.assessment.grad001.xolani.mvana.waste_sorting_api.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipRepo extends JpaRepository<RecyclingTip, Integer> {
}
