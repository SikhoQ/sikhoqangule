package com.enviro.assessment.grad001.sikhoqangule.controller;

import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import com.enviro.assessment.grad001.sikhoqangule.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * REST controller for managing Waste Categories.
 */
@RestController
@RequestMapping("/api/categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService service;

    /**
     * Retrieves a list of all Waste Categories.
     *
     * @return a list of WasteCategory entities
     */
    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return service.getAllCategories();
    }

    /**
     * Retrieves a Waste Category by its ID.
     *
     * @param id the ID of the Waste Category to retrieve
     * @return a ResponseEntity containing the Waste Category, or a 404 Not Found status if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    /**
     * Creates a new Waste Category.
     *
     * @param wasteCategory the Waste Category to create
     * @return the created WasteCategory entity
     */
    @PostMapping
    public WasteCategory createCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return service.createCategory(wasteCategory);
    }

    /**
     * Updates an existing Waste Category.
     *
     * @param id the ID of the Waste Category to update
     * @param wasteCategoryUpdate the updated Waste Category
     * @return a ResponseEntity containing the updated Waste Category, or a 404 Not Found status if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory wasteCategoryUpdate) {
        try {
            return ResponseEntity.ok(service.updateCategory(id, wasteCategoryUpdate));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a Waste Category by its ID.
     *
     * @param id the ID of the Waste Category to delete
     * @return a ResponseEntity with no content status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}