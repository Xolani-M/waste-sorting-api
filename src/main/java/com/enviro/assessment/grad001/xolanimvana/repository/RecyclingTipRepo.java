package com.enviro.assessment.grad001.xolanimvana.repository;

import com.enviro.assessment.grad001.xolanimvana.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipRepo extends JpaRepository<RecyclingTip, Long> {
}
