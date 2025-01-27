package com.enviro.assessment.grad001.sikhoqangule.controller;

import com.enviro.assessment.grad001.sikhoqangule.entity.RecyclingTip;
import com.enviro.assessment.grad001.sikhoqangule.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * REST controller for managing Recycling Tips.
 */
@RestController
@RequestMapping("/api/tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService service;

    /**
     * Retrieves a list of all Recycling Tips.
     *
     * @return a list of RecyclingTip entities
     */
    @GetMapping
    public List<RecyclingTip> getAllTips() {
        return service.getAllTips();
    }

    /**
     * Retrieves a Recycling Tip by its ID.
     *
     * @param id the ID of the Recycling Tip to retrieve
     * @return a ResponseEntity containing the Recycling Tip, or a 404 Not Found status if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long id) {
        return service.getTipById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new Recycling Tip.
     *
     * @param recyclingTip the Recycling Tip to create
     * @return the created RecyclingTip entity
     */
    @PostMapping
    public RecyclingTip createTip(@Valid @RequestBody RecyclingTip recyclingTip) {
        return service.createTip(recyclingTip);
    }

    /**
     * Updates an existing Recycling Tip.
     *
     * @param id the ID of the Recycling Tip to update
     * @param recyclingTipUpdate the updated Recycling Tip
     * @return a ResponseEntity containing the updated Recycling Tip, or a 404 Not Found status if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip recyclingTipUpdate) {
        try {
            return ResponseEntity.ok(service.updateTip(id, recyclingTipUpdate));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a Recycling Tip by its ID.
     *
     * @param id the ID of the Recycling Tip to delete
     * @return a ResponseEntity with no content status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        service.deleteTip(id);
        return ResponseEntity.noContent().build();
    }
}