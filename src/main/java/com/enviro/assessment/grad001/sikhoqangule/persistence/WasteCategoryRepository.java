package com.enviro.assessment.grad001.sikhoqangule.persistence;

import com.enviro.assessment.grad001.sikhoqangule.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}