package com.enviro.assessment.grad001.sikhoqangule.persistence;

import com.enviro.assessment.grad001.sikhoqangule.entity.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing DisposalGuideline entities.
 * Extends JpaRepository to provide CRUD operations.
 */
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
}