package com.enviro.assessment.grad001.sikhoqangule.controller;

import com.enviro.assessment.grad001.sikhoqangule.model.DisposalGuideline;
import com.enviro.assessment.grad001.sikhoqangule.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService service;

    @GetMapping
    public List<DisposalGuideline> getAllGuidelines() {
        return service.getAllGuidelines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id) {
        return service.getGuidelineById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DisposalGuideline createGuideline(@Valid @RequestBody DisposalGuideline disposalGuideline) {
        return service.createGuideline(disposalGuideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuideline disposalGuidelineUpdate) {
        try {
            return ResponseEntity.ok(service.updateGuideline(id, disposalGuidelineUpdate));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        service.deleteGuideline(id);
        return ResponseEntity.noContent().build();
    }
}