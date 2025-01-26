package com.enviro.assessment.grad001.sikhoqangule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "DISPOSAL_GUIDELINES")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100, message = "Disposal guideline must be between 3 and 100 characters")
    private String guideline;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({"recyclingTips", "disposalGuidelines"})
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