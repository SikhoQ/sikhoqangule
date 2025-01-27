package com.enviro.assessment.grad001.sikhoqangule.persistence;

import com.enviro.assessment.grad001.sikhoqangule.entity.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing RecyclingTip entities.
 * Extends JpaRepository to provide CRUD operations.
 */
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
}
