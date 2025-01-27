package com.enviro.assessment.grad001.sikhoqangule.persistence;

import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing WasteCategory entities.
 * Extends JpaRepository to provide CRUD operations.
 */
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}