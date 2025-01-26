package com.enviro.assessment.grad001.sikhoqangule.controller;

import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import com.enviro.assessment.grad001.sikhoqangule.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService service;

    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    @PostMapping
    public WasteCategory createCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return service.createCategory(wasteCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory wasteCategoryUpdate) {
        try {
            return ResponseEntity.ok(service.updateCategory(id, wasteCategoryUpdate));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}