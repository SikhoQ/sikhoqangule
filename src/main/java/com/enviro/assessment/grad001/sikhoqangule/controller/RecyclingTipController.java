package com.enviro.assessment.grad001.sikhoqangule.controller;

import com.enviro.assessment.grad001.sikhoqangule.model.RecyclingTip;
import com.enviro.assessment.grad001.sikhoqangule.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService service;

    @GetMapping
    public List<RecyclingTip> getAllTips() {
        return service.getAllTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long id) {
        return service.getTipById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RecyclingTip createTip(@Valid @RequestBody RecyclingTip recyclingTip) {
        return service.createTip(recyclingTip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip recyclingTipUpdate) {
        try {
            return ResponseEntity.ok(service.updateTip(id, recyclingTipUpdate));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        service.deleteTip(id);
        return ResponseEntity.noContent().build();
    }
}