package com.enviro.assessment.grad001.sikhoqangule.controller;

import com.enviro.assessment.grad001.sikhoqangule.entity.DisposalGuideline;
import com.enviro.assessment.grad001.sikhoqangule.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * REST controller for managing Disposal Guidelines.
 */
@RestController
@RequestMapping("/api/guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService service;

    /**
     * Retrieves a list of all Disposal Guidelines.
     *
     * @return a list of DisposalGuideline entities
     */
    @GetMapping
    public List<DisposalGuideline> getAllGuidelines() {
        return service.getAllGuidelines();
    }

    /**
     * Retrieves a Disposal Guideline by its ID.
     *
     * @param id the ID of the Disposal Guideline to retrieve
     * @return a ResponseEntity containing the Disposal Guideline, or a 404 Not Found status if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id) {
        return service.getGuidelineById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new Disposal Guideline.
     *
     * @param disposalGuideline the Disposal Guideline to create
     * @return the created DisposalGuideline entity
     */
    @PostMapping
    public DisposalGuideline createGuideline(@Valid @RequestBody DisposalGuideline disposalGuideline) {
        return service.createGuideline(disposalGuideline);
    }

    /**
     * Updates an existing Disposal Guideline.
     *
     * @param id the ID of the Disposal Guideline to update
     * @param disposalGuidelineUpdate the updated Disposal Guideline
     * @return a ResponseEntity containing the updated Disposal Guideline, or a 404 Not Found status if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuideline disposalGuidelineUpdate) {
        try {
            return ResponseEntity.ok(service.updateGuideline(id, disposalGuidelineUpdate));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a Disposal Guideline by its ID.
     *
     * @param id the ID of the Disposal Guideline to delete
     * @return a ResponseEntity with no content status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        service.deleteGuideline(id);
        return ResponseEntity.noContent().build();
    }
}