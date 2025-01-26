package com.enviro.assessment.grad001.sikhoqangule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "RECYCLE_TIPS")
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 150, message = "Recycle tip must be between 3 and 150 characters")
    private String tip;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({"recyclingTips", "disposalGuidelines"})
    private WasteCategory wasteCategory;

    // default constructor is required by JPA
    public RecyclingTip() {}

    // to allow easy population when configuring db
    public RecyclingTip(String tip, WasteCategory wasteCategory) {
        this.tip = tip;
        this.wasteCategory = wasteCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}