package com.enviro.assessment.grad001.sikhoqangule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Guidelines")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String guideline;

    @ManyToOne
    @JoinColumn(nullable = false)
    private WasteCategory wasteCategory;

    // default constructor is required by JPA
    public DisposalGuideline() {}

    // to allow easy population when configuring db
    public DisposalGuideline(String guideline, WasteCategory wasteCategory) {
        this.guideline = guideline;
        this.wasteCategory = wasteCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}